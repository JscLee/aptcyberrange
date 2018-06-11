provider "aws" {}

variable "logging" {
  default = true
  description = "if set to true, creates logging infrastructure"
}

resource "aws_key_pair" "terraform" {
  key_name = "key"
  public_key = "${file("key.pub")}"
}

resource "aws_vpc" "terraform" {
  cidr_block = "10.0.0.0/16"
  enable_dns_hostnames = "true"
}

resource "aws_internet_gateway" "terraform" {
  vpc_id = "${aws_vpc.terraform.id}"
  depends_on = ["aws_vpc.terraform"]
}

resource "aws_route_table" "terraform" {
  vpc_id = "${aws_vpc.terraform.id}"
  depends_on = ["aws_internet_gateway.terraform"]

  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = "${aws_internet_gateway.terraform.id}"
  }
}

resource "aws_subnet" "terraform" {
  vpc_id = "${aws_vpc.terraform.id}"
  cidr_block = "10.0.0.0/24"
  depends_on = ["aws_vpc.terraform"]
}

resource "aws_route_table_association" "terraform" {
  subnet_id = "${aws_subnet.terraform.id}"
  route_table_id = "${aws_route_table.terraform.id}"
  depends_on = ["aws_subnet.terraform", "aws_route_table.terraform"]
}

resource "aws_route53_zone" "terraform" {
  name = "fazio.com"
  vpc_id = "${aws_vpc.terraform.id}"
  depends_on = ["aws_vpc.terraform"]
}

resource "aws_security_group" "terraform" {
  name = "terraform"
  description = "only allow ssh, http, https"
  vpc_id = "${aws_vpc.terraform.id}"
  depends_on = ["aws_vpc.terraform"]

  ingress = {
    from_port = 22
    to_port = 22
    protocol = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress = {
    from_port = 0
    to_port = 0
    protocol = "-1"
    cidr_blocks = ["10.0.0.0/24"]
  }

  ingress = {
    from_port = 80
    to_port = 80
    protocol = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress = {
    from_port = 443
    to_port = 443
    protocol = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port       = 0
    to_port         = 0
    protocol        = "-1"
    cidr_blocks     = ["0.0.0.0/0"]
  }
}

resource "aws_instance" "ansible" {
  ami = "ami-01c6fc8c57cf28b40"
  instance_type = "t2.micro"
  security_groups = ["${aws_security_group.terraform.id}"]
  key_name = "key"
  subnet_id = "${aws_subnet.terraform.id}"
  associate_public_ip_address = true
  private_ip = "10.0.0.10"
  depends_on = ["aws_security_group.terraform", "aws_subnet.terraform"]

  connection {
    host = "${aws_instance.ansible.public_ip}"
    type = "ssh"
    user = "ubuntu"
    private_key = "${file("key")}"
    agent = false
  }

  provisioner "file" {
    source = "ansible/"
    destination = "~"
  }

  provisioner "remote-exec" {
    inline = [
      "sudo sed -i 's/127.0.0.1 localhost/127.0.0.1 ansible/g' /etc/hosts",
      "sudo hostname ansible"
    ]
  }
}

output "ansible ip" {
  value = "${aws_instance.ansible.public_ip}"
}
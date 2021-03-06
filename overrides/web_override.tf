resource "aws_route53_record" "web" {
  zone_id = "${aws_route53_zone.terraform.zone_id}"
  name = "web.fazio.com"
  type = "A"
  ttl = "300"
  records = ["${aws_instance.web.private_ip}"]
  depends_on = ["aws_instance.web", "aws_route53_zone.terraform"]
}

resource "aws_instance" "web" {
  ami = "ami-0a89a00e012137c56"
  instance_type = "t2.micro"
  security_groups = ["${aws_security_group.terraform.id}"]
  key_name = "key"
  subnet_id = "${aws_subnet.terraform.id}"
  associate_public_ip_address = true
  private_ip = "10.0.0.16"
  depends_on = ["aws_route_table.terraform", "aws_security_group.terraform", "aws_subnet.terraform"]

  connection {
    host = "${aws_instance.web.public_ip}"
    type = "ssh"
    user = "ubuntu"
    private_key = "${file("key")}"
    agent = false
  }

  provisioner "file" {
    source = "ansible"
    destination = "/home/ubuntu"
  }

  provisioner "remote-exec" {
    inline = [
      "ansible-playbook /home/ubuntu/ansible/bootstrap/web.yml"
    ]
  }
}

output "web ip" {
  value = "${aws_instance.web.public_ip}"
}
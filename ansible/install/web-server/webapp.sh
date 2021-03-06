MYSQL_ROOT=root
MYSQL_PASS=root
DB_NAME=target_exemplar
export MYSQL_ROOT ; export MYSQL_PASS ; export DB_NAME

sudo apt-get update -y
# sudo apt-get upgrade -y # this commands require interaction

# Enable Ubuntu Firewall and allow SSH & MySQL Ports
sudo ufw allow in "Apache Full"

# Apache Installation
echo "Apache Installation Starts!"
sudo apt-get install -y apache2
sudo systemctl restart apache2

# Careful about ht file path!
cd ~
sudo git clone https://github.com/abemelvin/tiamat/
sudo mv -v ~/tiamat/terraform/ansible/install/web-server/html/*  /var/www/html/
sudo chgrp -R www-data /var/www
# sudo chmod -R g+w ubuntu
sudo chmod 755 /var/www/html/ #7 - rwx 5 - r-x 5 - r-x
sudo chmod 777 /var/www/html/images #7 - rwx 5 - r-x 5 - r-x
sudo mv -f ~/tiamat/terraform/ansible/web-server/dir.conf /etc/apache2/mods-enabled/dir.conf


# MySQL Installation
# -------------------
# Install MySQL Server in a Non-Interactive mode. Default root password will be "root"
echo "MySQL Installation Starts!"
sudo echo "mysql-server-5.7 mysql-server/root_password password root" | sudo debconf-set-selections
sudo echo "mysql-server-5.7 mysql-server/root_password_again password root" | sudo debconf-set-selections
sudo apt-get install -y mysql-server 


# PHP Installation
# -------------------
# Install php itself
echo "PHP Installation Starts!"
sudo apt-get install -y php
sudo apt-get install -y libapache2-mod-php 
sudo apt-get install -y php-mcrypt 
sudo apt-get install -y php-mysql
sudo apt-get install -y php-cli 
sudo apt-get install -y php-curl
# Enable mycrpt for PHP5
sudo php5enmod mcrypt
# sudo systemctl status apache2




# # PHPmyadmin Installation
# # -------------------
# # Install PHPMyAdmin NOT ADVISABLE FOR PRODUCTION
# sudo echo "phpmyadmin phpmyadmin/dbconfig-install boolean true" | debconf-set-selections
# sudo echo "phpmyadmin phpmyadmin/app-password-confirm password $MYSQL_PASS" | debconf-set-selections
# sudo echo "phpmyadmin phpmyadmin/mysql/admin-pass password $MYSQL_PASS" | debconf-set-selections
# sudo echo "phpmyadmin phpmyadmin/mysql/app-pass password $MYSQL_PASS" | debconf-set-selections
# sudo echo "phpmyadmin phpmyadmin/reconfigure-webserver multiselect apache2" | debconf-set-selections
# sudo apt-get install -y phpmyadmin
# # Make PHPMyAdmin available as http://localhost/phpmyadmin
# # ln -s /usr/share/phpmyadmin /usr/share/nginx/html/phpmyadmin


# Create exemplar database
# -------------------
echo "Database Example Creation Starts!"
sudo mysql -u "$MYSQL_ROOT" -p"$MYSQL_PASS"  -e "create database $DB_NAME"
# Careful about ht file path!
sudo mysql -u "$MYSQL_ROOT" -p"$MYSQL_PASS" "$DB_NAME" < ~/tiamat/terraform/ansible/web-server/target_exemplar.sql
# else
#   sudo mysql -u$MYSQL_ROOT $DB_NAME < target_exemplar.sql
# fi


sudo systemctl restart apache2




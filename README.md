# Threat Instrumentation And Machine Automation Tool

## Table of contents

1. [Introduction](https://github.com/apt2018/aptcyberrange#1-introduction-)
2. [Installation](https://github.com/apt2018/aptcyberrange#2-installation-)   
3. [Getting started](https://github.com/apt2018/aptcyberrange#3-getting-started-)
4. [Building machine images](https://github.com/apt2018/aptcyberrange#4-building-machine-images-)      
5. [Deploying the testbed](https://github.com/apt2018/aptcyberrange#5-deploying-the-testbed-)   
6. [Provisioning the testbed](https://github.com/apt2018/aptcyberrange#6-provisioning-the-testbed-)   
7. [Destroying the testbed](https://github.com/apt2018/aptcyberrange#7-destroying-the-testbed-)   
8. [Data collection and analysis](https://github.com/apt2018/aptcyberrange#8-data-collection-and-analysis-)   
9. [Running the examplar attack scenario](https://github.com/apt2018/aptcyberrange#9-running-the-examplar-attack-scenario-) 
10. [System Infrastructure](https://github.com/apt2018/aptcyberrange#10-system-infrastructure-)
11. [Future Work](https://github.com/apt2018/aptcyberrange#11-future-work-)

---

## 1. Introduction [↑](https://github.com/apt2018/aptcyberrange)

The system supports a Domain Specific Language (DSL), Stitch, which is developed by Shang Wen Cheng, David Garlan, Bradley Schmerl and so on.

To start using the system, users should input some Stitch scripts. Scripts can be written from two sides, attacker and defender, to do the simulation and experiment. Each side of Stitch scripts should contain one strategy script and one tactic script. The attacker’s tactic script should be named as "attackerTactics.s" and the defender’s tactic script should be named as "defenderTactics.s". Researchers can play roles of attacker and defender concurrently. 

- **Operations provided**

  You can only use operations that we support in Stitch scripts. Attacker can use the operations including "sendPhishingEmail", "A.downloadLogFile", "A.decodeLogFile", "A.loginWeb", "A.injectShell", "A.crackPasswd", "A.storePasswd", "A.firmware", "A.transaction", "A.deleteLogFile", "A.deleteWebCredential", "F.deleteLogFile".

  Defender can use the operations including "filterPhisihngEmail", "W.resetPassword", "increaseWebThreshold".

  You can also add whatever operations you want, just remember to write statements about those operations in tactic’s actions. After using the system’s Antlr visitors, these Stitch statements will be finally directed to execOperations(str) function in Model file. The "str" here is a parameter of String data type, which corresponds to a kind of nodes "MethodCall" in the generated Abstract Syntax Tree (AST). Therefore, specific operations should be implemented or called in this execOperations(str) function.

- **Boolean conditions provided**

  Conditions of the system are represented by some Boolean values. Accepted Boolean conditions include "hasWebCredential", "hasLogFile", "hasCardCredential", "webPasswdExpired". Other data types of conditions like "W.time" and "W.threshold" are stored and used to set the Boolean condition. Some files in the system also have values to represent its status. For example, email has a Boolean value "isPhishingEmail" to indicate whether it is a phishing email or not.

  We did not write most of our conditions as "define Boolean xxx = exists …" like other Stitch examples because of 2 reasons. First, this system is not as complicated as Rainbow and we do not have so many servers to monitor, which means it is unnecessary to write them all in that complex way. Second, we want to update these conditions in real time instead of setting all of them in the beginning of strategy script.
  
  Also, you can add other conditions if you want. If they are written in the same way in scripts as our system, their related updated functions should be implemented in the Probe or in execHook(str) function in the Model.

- **Model description**

  We have provided an interface of Model and implemented one kind of model named "TargetModel". Our model uses some data structures like HashMap and HashSet to store servers’ IP addresses, tactics visited, hooks, probes, time thresholds, and so on. We also implemented hooks and operations in execHook(str) and execOperations(str).

  Each system of a specific number of servers should have only 1 related model to store its status and methods. If the system is changed, either category of servers or number of servers has been changed. A new model needs to be implemented. You can add any number of models if you want to change the system into any structure.


## 2. Installation [↑](https://github.com/apt2018/aptcyberrange)

Tiamat does not require compilation which makes installation extremely simple. Just clone the Tiamat repository to your local machine by running `git clone https://github.com/apt2018/aptcyberrange.git` in your shell.

## 3. Getting started [↑](https://github.com/apt2018/aptcyberrange)

Before using Tiamat, add the path of three jar packages in directory antrlDemo to variable CLASSPATH.

To start using Tiamat, execute the `tiamat.py` script located in the `tiamat/` directory by running `python tiamat.py`.

Tiamat utilizes Terraform (https://www.terraform.io) to instantiate the infrastructure needed to host your testbed. Terraform accesses various AWS APIs which require you to have a validated AWS account and to also specify your AWS access keys in your environment. Tiamat will check that your environment is correctly configured before allowing you to proceed to deployment. 

Tiamat will also check that your PATH variable contains valid executables of Terraform and Packer (for image building),  and will assist you in downloading them if they are not found. 

## 4. Building machine images [↑](https://github.com/apt2018/aptcyberrange)

To build machine images before deployment, use the `build` command in the Tiamat shell. All machine images will be provisioned by the Ansible provisioning scripts. 

## 5. Deploying the testbed [↑](https://github.com/apt2018/aptcyberrange)

Tiamat maintains a list of servers that are currently flagged to be deployed.
You can view this list by running `show deployment list` in the Tiamat shell:

~~~
(Tiamat) show deployment list
- elk
- contractor
- blackhat
- mail
- ftp
~~~

To view a list of all the servers that you can add to the deployment list,
run `show available` in the Tiamat shell:

~~~
(Tiamat) show available
- blackhat
- contractor
- elk
- ftp
- mail
- payments
- wazuh
- web
~~~

To add servers to the deployment list, run `add server [name]` in the
Tiamat shell, replacing `[name]` with the specific server identifier:

~~~
(Tiamat) add server payments
~~~

To remove servers from the deployment list, run `remove server [name]` in the
Tiamat shell, replacing `[name]` with the specific server identifer:

~~~
(Tiamat) remove server payments
~~~

The currect system needs to add at least the following servers

~~~
- blackhat
- contractor
- ftp
- mail
- payments
- wazuh
- web
- elk
~~~

Once you are satisfied with your server list, you can proceed with deployment
by running `deploy` in the Tiamat shell:

~~~
(Tiamat) deploy
~~~

After initiating deployment, Tiamat will first check your deployment
template for errors. If an error is detected, this may indicate that the
`tiamat/configuration.tf` file is damaged. If you are confident
that this is not the case, you can proceed with deployment by following
the prompts.

Once deployment is complete, you will be presented with the public IP addresses
of your servers. If you wish to SSH directly into your servers or to access
a web service running on your servers, you will need this information:

~~~
Outputs:

ansible ip = 54.242.186.67
payments ip = 34.207.64.90
~~~

At anytime, you can run `show active servers`  to view the the list of currently deployed servers and their public IP addresses:

```
(Tiamat) show active servers
- ansible: 54.242.186.67
- payments: 34.207.64.90
```

The global states including deployment status, active server list and their public IP addresses are saved in JSON format in global_state.json under the Tiamat directory. Please keep this file uncorrupted. In case of  unexpected errors regarding the global states, you may need to delete global_state.json manually.

After the deployment, you can launch the java RMI server on every running server by running `launch` in the Tiamat shell:

~~~
(Tiamat) launch
~~~

This command will set up all the required programs on remote servers.

## 6. Provisioning the testbed (Optional) [↑](https://github.com/apt2018/aptcyberrange)

(In step 3 "Building machine images", all servers have been provisioned during image building, so it's not necessay to provision again here. However, if you are going to modify the configuration or provision some new scripts, you may follow this instruction to provision a specific server.)

Once deployment is complete, you will need to provision the instantiated servers with the appropriate software packages. Automated provisioning scripts are provided for each available server, which can be executed using Ansible. To connect to Ansible, run `ansible` in the Tiamat shell:

~~~
(Tiamat) ansible
~~~

Once you have a secure shell to Ansible, you can execute the provisioning scripts that correspond to the servers you deployed. For example, if you only chose to deploy the payments server, you would provision that server like so:

~~~
ubuntu@ip-10-0-0-10:~$ ansible-playbook install/payment_server.yml
~~~

Once you have provisioned the testbed, you can interact with the environment as you see fit.

## 7. Destroying the testbed [↑](https://github.com/apt2018/aptcyberrange)

Since your testbed is deployed on AWS, you will be charged based on the volume and length of your usage. Therefore, it is key to destroy the testbed once you are done with your experiments. To do this, run `destroy`:

~~~
(Tiamat) destroy
~~~

Terraform will confirm your intent to destroy one final time before the process is initiated. Try not to interrupt the destruction process once it has started, as it could prevent Terraform from halting gracefully and damage your state file in the process.

## 8. Data collection and analysis [↑](https://github.com/apt2018/aptcyberrange)

Tiamat utilizes the Elastic Stack (Elasticsearch, Logstash, Kibana) to perform log data integration, search, and visualization. It also incorporates Wazuh, a host-based intrusion detection system built on Elastic Stack to perform log analysis, integrity checking, rootkit detection, time-based alerting, and active response.

When provisioning the system, you can paste the public IP address of elk/wazuh into a web browser to open the Kibana/Wazuh dashboard. The `elk` command also does the same work.

To download the log files from ELK server to local folder, type in the following command:

```
(Tiamat) save logs
```

To download the .pcap file from each server, type in the following command:

```
(Tiamat) save pcaps
```

![Data-collection](https://github.com/apt2018/aptcyberrange/blob/master/doc/img/Data%20Collection.png?raw=true)

## 9. Running the examplar attack scenario [↑](https://github.com/apt2018/aptcyberrange)

In this section, we run through an examplar attack scenario provided by Tiamat to demonstrate

the use of the testbed. The system-under-test (SUT) consists of the following host machines:

```
(Tiamat) show deployment list
- contractor
- blackhat
- mail
- web
- payments
- sales
- ftp
- elk
- wazuh
```

The attack pipeline is as follows:

![Scenario](https://github.com/apt2018/aptcyberrange/blob/master/doc/img/Scenario.png?raw=true)

After deployment and launch, we should first compile all the java file:

~~~
$ javac antlrDemo/*.java
~~~

The automation master on defender side can be started by:

~~~
$ java antlrDemo/StitchDefender defenderTactics.s defenderStrategies.s
~~~

And the automation master on attacker side can be started by:

~~~
$ java antlrDemo/StitchAttacker attackerTactics.s attackerStrategies.s
~~~

If only the attacker side will be run during the experiment, the content of mailpath.txt on contractor server should be manually modified to

~~~
/home/ubuntu/mail/new/
~~~

## 10. System Infrastructure [↑](https://github.com/apt2018/aptcyberrange)

Here is the general picture of the system infrastructure. It may help you understand how TIAMAT works.

![Infrastructure](https://github.com/apt2018/aptcyberrange/blob/master/doc/img/Infrastructure.png?raw=true)

## 11. Future Work [↑](https://github.com/apt2018/aptcyberrange)

Quantified Expression not useful in our model, because we do not have a list of servers in our model. Thus we use idExpression only. In the future, in a new model, we might expand the "machines" hashmap into a hashmap<String, List<String>>, and add some functions (like: getList(String typeOfComponent)) to return the list of ideal type to the quantified expression.

Since the current system has not implemented all Stitch grammar, and Stitch has more statements than what we implemented now such as "exists", "set", "forall", etc. More advantages of Stitch grammar can be utilized in the future.

The defense in our simulation is still weak and incomplete, more defender’s strategies and tactics can be explored in the future. How to better design defender’s strategies and related trigger conditions, how to monitor more system status from a defender’s side are left for future work. 

We have avoided using (success) (default) in the strategies. To support the use of success, default/ other scope dependent variable, an external tree/stack structure will have to be created, to store the variables

Currently the AnsibleServer takes 6 arguments (hard coded), because the system under test only involves 6 servers. Since AnsibleServer is model dependent, it should not be a big problem. The way we call the line: "java -Djava.rmi.server.hostname=ec2-34-229-137-88.compute-1.amazonaws.com AnsibleServer 15213" on the ansible server (and other 6 servers) is through a class 'launch' in tiamat.py, which takes the ip-addresses of 7 servers (ansible + other six) as input (and construct the hostname each time it gets deployed).

Currently we do not have type checking visitors and enough error handlers - we assume the Stitch scripts are written correctly.

We do not have an option to properly display debug information on the commandline interface. We do have several (many) sentences indicating what is going on in which function, but we cannot choose whether to display them or not via a "--debug" or "--verbose" option. Currently all the debug informations are stdout outputs, and they are commented out. A logger might be utilized to achieve this.

More data analytics game theory methods and can be used to evaluate the experiments in the future. 

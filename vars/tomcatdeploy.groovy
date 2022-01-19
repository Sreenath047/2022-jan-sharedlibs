def call(credid,tomcatip,tomcatuser){
    sshagent([credid]) {
        // copy war file to tomcat server
        sh """
        scp -o StrictHostKeyChecking=no target/myweb*.war ${tomcatuser}@${tomcatip}:/opt/tomcat8/webapps/myweb.war
        ssh ${tomcatuser}@${tomcatip} /opt/tomcat8/bin/startup.sh
        """
    }
}

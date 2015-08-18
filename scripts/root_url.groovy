import jenkins.model.*
jlc = JenkinsLocationConfiguration.get()
jlc.setUrl('http://my.jenkins.com/')
jlc.save()
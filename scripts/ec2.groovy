import jenkins.model.Jenkins;
import hudson.model.Node;
import hudson.plugins.ec2.*;
import com.amazonaws.services.ec2.model.InstanceType;

EC2Tag nameTag = new EC2Tag("key", "value");
List<EC2Tag> tags = new ArrayList<EC2Tag>();
tags.add(nameTag);

// WHY DOESN'T THIS WORK!?!?!?
// The constructor signatures match, yet it says it can't find a constructor when I used InstanceType.
// The tests run, so what's going on?
//InstanceType type = InstanceType.M1Large;
InstanceType type = null;
SlaveTemplate large = new SlaveTemplate("ami_id", "", null, "Security group names", "Remote FS root", type, false, "Labels", Node.Mode.NORMAL, "Description", "", "", "", "Number of executors", "Remote user", new UnixData("sudo", "22"), "", false, "", tags, null, false, null, "", false, false, "", false, "");

List<SlaveTemplate> templates = new ArrayList<SlaveTemplate>();
templates.add(large);

AmazonEC2Cloud cloud = new AmazonEC2Cloud("region", false, "access_key_id", "secret_access_key", "region", "private_key", "", templates);
def instance = Jenkins.getInstance();
instance.clouds.add(cloud);
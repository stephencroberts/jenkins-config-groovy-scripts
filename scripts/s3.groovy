import jenkins.model.*
import hudson.plugins.s3.*
import org.kohsuke.stapler.StaplerRequest

def profiles = new ArrayList<S3Profile>()
profiles.add(new S3Profile("profile_name", "access_key_id", "secret_access_key", null, null, false))
def req = [
  bindParametersToList : { type, prefix -> profiles }
] as StaplerRequest

def s3 = Jenkins.instance.getExtensionList(S3BucketPublisher.DescriptorImpl.class)[0]
s3.configure(req, null)
s3.save()
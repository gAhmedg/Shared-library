
def call(Map config = [:] ) {
	
         kubernetesDeploy( configs: "${config.pathofyamlfile}" , kubeconfigId: "${config.k8scerdential}" )
       
      	 
}
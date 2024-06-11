def call(Map config = [:]) {

 withKubeCredentials(kubectlCredentials: [[caCertificate: '',
                                           clusterName: '',
                                           contextName: '',
                                           credentialsId: config.credentialsId,
                                           namespace: '',
                                           serverUrl: config.ClusterUrl]])
                {    
                 sh "kubectl apply -f ${config.file} -n ${config.namespace}" 
                        }


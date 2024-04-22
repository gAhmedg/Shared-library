def call(Map config = [:]) {
  sh "docker build --tag ${config.image} ."

 String x = config.DockerCredentials ;

  withCredentials([usernamePassword(credentialsId: x , passwordVariable: 'password', usernameVariable: 'user')]) {
   sh "docker login -u ${user} -p ${password}"

}
  sh "docker push ${config.image}"
}

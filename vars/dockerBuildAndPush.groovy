def call(Map config = [:]) {
  sh "docker build --tag ${config.image} ."

 

  withCredentials([usernamePassword(credentialsId: "config.DockerCredentials", passwordVariable: 'password', usernameVariable: 'user')]) {
   sh "docker login -u ${user} -p ${password}"

}
  sh "docker push ${config.image}"
}

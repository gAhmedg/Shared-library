#!usr/bin/env groovy
def call( String imageName) {
	
        
        // Build and push Docker image
        echo "Building and Pushing Docker image..."
        sh "docker build -t ${imageName}:${BUILD_NUMBER} ."
        sh "docker push ${imageName}:${BUILD_NUMBER}"	 
}
pipeline {
  agent any

  tools {
    jdk 'jdk21'      // Cambia por el nombre del JDK configurado en Manage Jenkins → Tools
    maven 'Maven3'   // Cambia por el nombre de tu instalación de Maven
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Build & Test') {
      steps {
        script {
          def cmd = 'mvn -B -DskipTests=false clean test'
          if (isUnix()) { sh cmd } else { bat cmd }
        }
      }
    }
  }

  post {
    always {
      junit 'target/surefire-reports/*.xml'
      archiveArtifacts artifacts: 'target/**/*', allowEmptyArchive: true
    }
  }
}

def call(boolean abortPipeline = false, boolean useSonarQube = true) {
    if (useSonarQube) {
        // Ejecutar el escaneo de SonarQube
        echo "Ejecutando análisis de SonarQube..."
        // Puedes agregar aquí el comando real para ejecutar SonarQube
        // Ejemplo de comando ficticio:
        // sh 'sonar-scanner' 
    } else {
        // Usar "echo" en lugar de SonarQube
        echo "Ejecución de las pruebas de calidad de código"
    }

    // Simular una verificación de QualityGate (cambia esto según tu caso real)
    def qualityGatePassed = true

    if (qualityGatePassed) {
        echo "QualityGate: éxito"
    } else {
        echo "QualityGate: fallo"
        if (abortPipeline) {
            currentBuild.result = 'FAILURE'
            error "QualityGate falló, se aborta el pipeline."
        }
    }
}


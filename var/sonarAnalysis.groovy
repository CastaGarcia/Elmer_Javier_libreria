// vars/sonarAnalysis.js

function sonarAnalysis(abortPipeline = false, useSonarQube = true) {
    if (useSonarQube) {
        console.log("Ejecutando análisis de SonarQube...");
        // Puedes agregar aquí el código real para ejecutar SonarQube
    } else {
        console.log("Ejecución de las pruebas de calidad de código");
    }

    // Simular una verificación de QualityGate (cambia esto según tu caso real)
    const qualityGatePassed = true;

    if (qualityGatePassed) {
        console.log("QualityGate: éxito");
    } else {
        console.log("QualityGate: fallo");
        if (abortPipeline) {
            // Aquí puedes agregar lógica para abortar el pipeline en JavaScript, si es necesario.
            throw new Error("QualityGate falló, se aborta el pipeline.");
        }
    }
}

// Exporta la función para que pueda ser utilizada por otros scripts
module.exports = sonarAnalysis;

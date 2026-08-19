// 1. Definimos las dos APIs que vas a consumir
const API_1 = 'http://localhost:8080/api/characters'; 
const API_2 = 'http://localhost:8081/api/characters'; 

// 2. Elementos del HTML
const fighter1Select = document.getElementById('fighter1'); 
const fighter2Select = document.getElementById('fighter2'); 
const fighter1Image = document.getElementById('fighter1Image'); 
const fighter2Image = document.getElementById('fighter2Image'); 
const fightButton = document.getElementById('fightButton'); 
const resultDiv = document.getElementById('result'); 

// 3. Arreglo para guardar todos los personajes de ambas APIs
let todosLosLuchadores = []; 

// 4. Función para obtener la URL de forma segura
function getImageUrl(fighter) {
    if (!fighter) return '';
    
    return fighter.URLimagen || 
           fighter.urlImagen || 
           fighter.urlimagen || 
           fighter.url_imagen ||
           fighter.imagen || 
           fighter.imgurl || // Soporte para el código anterior
           fighter.foto || 
           fighter.img || 
           fighter.url || 
           '';
}

// 5. Función segura para actualizar imágenes
function updateFighterImage(selectElement, imageElement) {
    if (!selectElement.value) return;
    try {
        const selected = JSON.parse(selectElement.value); 
        const url = getImageUrl(selected);
        
        if (url && url.trim() !== '') {
            imageElement.src = url; 
        } else {
            imageElement.src = 'https://placehold.co/150?text=Sin+Imagen';
        }
    } catch (error) {
        console.error("Error al procesar el personaje:", error);
    }
}

// 6. Traer los datos de ambas APIs
async function fetchData() {     
    let personajesApi1 = [];
    let personajesApi2 = [];

    try { 
        const response1 = await fetch(API_1); 
        personajesApi1 = await response1.json(); 
    } catch (error) { 
        console.error('Error al cargar la API 1:', error); 
    } 

    try { 
        const response2 = await fetch(API_2); 
        personajesApi2 = await response2.json(); 
    } catch (error) { 
        console.error('Error al cargar la API 2:', error); 
    } 

    // Combinamos ambos resultados
    todosLosLuchadores = [...personajesApi1, ...personajesApi2];
    console.log("Personajes totales cargados:", todosLosLuchadores);
    
    loadFighters(); 
} 

// 7. Llenar los selectores
function loadFighters() { 
    fighter1Select.innerHTML = '';
    fighter2Select.innerHTML = '';

    todosLosLuchadores.forEach(fighter => { 
        const armas = fighter.armas || fighter.Armas || [];
        const ataques = fighter.ataques || [];
        
        // Buscar un nombre de arma o ataque para mostrar
        let nombreExtra = '';
        if (armas.length > 0 && armas[0]?.nombre) {
            nombreExtra = ` (${armas[0].nombre})`;
        } else if (ataques.length > 0 && ataques[0]?.nombre) {
            nombreExtra = ` (${ataques[0].nombre})`;
        }

        const textContent = `${fighter.nombre}${nombreExtra}`;

        const option1 = document.createElement('option'); 
        option1.value = JSON.stringify(fighter); 
        option1.text = textContent; 
        fighter1Select.appendChild(option1); 

        const option2 = document.createElement('option');
        option2.value = JSON.stringify(fighter); 
        option2.text = textContent; 
        fighter2Select.appendChild(option2); 
    }); 

    // Seleccionar el segundo personaje por defecto para el Jugador 2
    if (fighter2Select.options.length > 1) {
        fighter2Select.selectedIndex = 1;
    }

    // Renderizar imágenes iniciales
    updateFighterImage(fighter1Select, fighter1Image);
    updateFighterImage(fighter2Select, fighter2Image);
}

// 8. Eventos para escuchar cuando el usuario cambia de personaje
fighter1Select.addEventListener('change', () => updateFighterImage(fighter1Select, fighter1Image)); 
fighter2Select.addEventListener('change', () => updateFighterImage(fighter2Select, fighter2Image)); 

// 9. Función auxiliar para calcular el daño total dinámicamente
function calcularDanioTotal(fighter) {
    let danioBase = Number(fighter.danioBase) || 0;
    let bonificador = Number(fighter.bonificadorDanio) || 0;

    // Soporte para estructura de ataques múltiples (código anterior)
    if (fighter.ataques && fighter.ataques.length > 0) {
        const ataqueAleatorio = fighter.ataques[Math.floor(Math.random() * fighter.ataques.length)];
        danioBase = Number(ataqueAleatorio.danioBase) || danioBase;
    }
    
    // Soporte para estructura de armas (código anterior)
    if (fighter.armas && fighter.armas.length > 0) {
        bonificador = Number(fighter.armas[0].bonificadordano) || bonificador;
    }

    return Math.max(1, danioBase + bonificador);
}

// 10. Lógica de Simulación de Combate
fightButton.addEventListener('click', () => { 
    if (!fighter1Select.value || !fighter2Select.value) { 
        alert('Por favor, seleccioná ambos luchadores.'); 
        return; 
    } 

    let fighter1, fighter2;

    try {
        fighter1 = JSON.parse(fighter1Select.value); 
        fighter2 = JSON.parse(fighter2Select.value); 
    } catch (error) {
        console.error("Error al leer los datos de los luchadores:", error);
        alert("Hubo un problema al cargar los datos de los personajes.");
        return;
    }

    // --- 📊 REGISTROS EN CONSOLA (GRUPO DE COMBATE) ---
    console.group("⚔️ === SIMULACIÓN DE COMBATE ===");
    console.log("Luchador 1 (Objeto crudo):", fighter1);
    console.log("Luchador 2 (Objeto crudo):", fighter2);

    // Forzar conversión a Números y establecer mínimos
    const vida1 = Math.max(1, Number(fighter1.puntosVida) || 1);
    const vida2 = Math.max(1, Number(fighter2.puntosVida) || 1);

    const danioTotal1 = calcularDanioTotal(fighter1);
    const danioTotal2 = calcularDanioTotal(fighter2);

    const nombre1 = fighter1.nombre || "Luchador 1";
    const nombre2 = fighter2.nombre || "Luchador 2";

    console.log(`📈 Estadísticas procesadas:`);
    console.log(`> ${nombre1} -> Vida: ${vida1} | Daño Total por turno: ${danioTotal1}`);
    console.log(`> ${nombre2} -> Vida: ${vida2} | Daño Total por turno: ${danioTotal2}`);

    // Calcular turnos necesarios
    const turnosParaVencerF2 = Math.ceil(vida2 / danioTotal1);
    const turnosParaVencerF1 = Math.ceil(vida1 / danioTotal2);

    console.log(`⏱️ Cálculo de turnos:`);
    console.log(`> Turnos que necesita ${nombre1} para derrotar a ${nombre2}: ${turnosParaVencerF2}`);
    console.log(`> Turnos que necesita ${nombre2} para derrotar a ${nombre1}: ${turnosParaVencerF1}`);

    // Determinar el ganador
    let mensajeResultado;
    if (turnosParaVencerF2 < turnosParaVencerF1) { 
        mensajeResultado = `🏆 ¡El ganador es: ${nombre1}!`; 
    } else if (turnosParaVencerF1 < turnosParaVencerF2) { 
        mensajeResultado = `🏆 ¡El ganador es: ${nombre2}!`; 
    } else { 
        mensajeResultado = "⚔️ ¡Es un empate!"; 
    } 

    console.log(`🏁 Veredicto: ${mensajeResultado}`);
    console.groupEnd(); 

    // Mostrar el contenedor del resultado en la interfaz
    resultDiv.textContent = mensajeResultado; 
    resultDiv.classList.remove('hidden'); 
});

// 11. Iniciar la carga
fetchData();
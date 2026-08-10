const API_NARUTO = 'http://localhost:8080/api/characters'; 

const fighter1Select = document.getElementById('fighter1'); 
const fighter2Select = document.getElementById('fighter2'); 
const fighter1Image = document.getElementById('fighter1Image'); 
const fighter2Image = document.getElementById('fighter2Image'); 
const fightButton = document.getElementById('fightButton'); 
const resultDiv = document.getElementById('result'); 

let ninjas = []; 

// Función para obtener la URL de forma segura sin importar cómo venga la propiedad desde el backend
function getImageUrl(fighter) {
    if (!fighter) return '';
    console.log("Datos del personaje seleccionado para imagen:", fighter);

    return fighter.URLimagen || 
            fighter.urlImagen || 
            fighter.urlimagen || 
            fighter.url_imagen ||
            fighter.imagen || 
            fighter.foto || 
            fighter.img || 
            fighter.url || 
            '';
}

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

async function fetchData() {     
    try { 
        const responseNaruto = await fetch(API_NARUTO); 
        ninjas = await responseNaruto.json(); 
        console.log("Personajes cargados exitosamente desde la API:", ninjas);
        loadFighters(); 
    } catch (error) { 
        console.error('Error al cargar los personajes:', error); 
    } 
} 

function loadFighters() { 
    fighter1Select.innerHTML = '';
    fighter2Select.innerHTML = '';

    ninjas.forEach(fighter => { 
        const armas = fighter.armas || fighter.Armas || [];
        const nombreArma = (armas.length > 0 && armas[0] && armas[0].nombre) 
            ? ` (${armas[0].nombre})` 
            : '';

        const textContent = `${fighter.nombre}${nombreArma}`;

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

// Eventos únicos para escuchar cuando el usuario cambia de personaje
fighter1Select.addEventListener('change', () => updateFighterImage(fighter1Select, fighter1Image)); 
fighter2Select.addEventListener('change', () => updateFighterImage(fighter2Select, fighter2Image)); 

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

    const danioTotal1 = Math.max(1, (Number(fighter1.danioBase) || 0) + (Number(fighter1.bonificadorDanio) || 0));
    const danioTotal2 = Math.max(1, (Number(fighter2.danioBase) || 0) + (Number(fighter2.bonificadorDanio) || 0));

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
    console.groupEnd(); // Cierra el grupo visual en la consola

    // Mostrar el contenedor del resultado en la interfaz
    resultDiv.textContent = mensajeResultado; 
    resultDiv.classList.remove('hidden'); 
});

fetchData();
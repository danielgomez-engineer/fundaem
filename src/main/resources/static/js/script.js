const aboutText="La Fundación Deportiva Elina Morales tiene como objetivo incentivar la práctica deportiva con el fin de llegar a aquellos niños y jóvenes que se encuentren en situaciones desfavorecidas, sin recursos o con alguna discapacidad física o psíquica y con riesgo de exclusión social, apoyándolos en lo social.";
document.getElementById("about-text").textContent=aboutText;

const aboutMision ="mejorar la calidad de vida de los deportistas en diferentes categorías y edades de bajos recursos, con habilidades deportivas a través de la promoción de oportunidades de formación, desarrollo, rehabilitación física y psicológica deportiva, contando con el apoyo de los patrocinadores voluntarios y el capital humano altamente capacitado que lo integra.";
document.getElementById("about-mision").textContent=aboutMision;

const aboutVision =" ser una fundación reconocida por la comunidad, instituciones públicas y privadas, como también de los atletas de alto rendimiento y proyectar las capacidades de sus beneficiarios desde la articulación y apoyo en las diferentes áreas deportivas, asimismo el compromiso de sus patrocinadores, colaboradores y de ser una entidad económicamente autosostenible.";
document.getElementById("about-vision").textContent=aboutVision;


const descripcion ="Únete a nuestro equipo de voluntarios y ayuda a transformar vidas a través del deporte.";
document.getElementById("descripcion").textContent=descripcion;


//------------------------------------EVENTOS---------------------------------------------
/////primer evento
const sombLoco = "Sombrero loco";
document.getElementById("tituloSombLoco").textContent=sombLoco;
const descripcionSombLoco = "El 17 de diciembre se celebró la competencia del Sombrero Loco en el Parque Mareigua Paramo, reuniendo a participantes de todas las edades para mostrar sombreros originales y creativos. Los concursantes presentaron diseños extravagantes, que fueron evaluados por su creatividad, originalidad y técnica. Todos recibieron premios por su esfuerzo. Además, hubo actividades para toda la familia, como bailoterapia, música en vivo y juegos. Los organizadores agradecieron la participación y anunciaron planes para futuras ediciones, manteniendo viva la tradición de creatividad y diversión.";
document.getElementById("descripcionSombLoco").textContent=descripcionSombLoco;

//// segundo evento
const maCometas = "Maratón de Cometas: Corre contra el viento";
document.getElementById("titulomaCometas").textContent=maCometas;
const descripcionmatCometas = "El domingo 1 de diciembre, la cancha del barrio Doce de Octubre se llenó de color y alegría con el 1er. Maratón de Cometas. Familias y amigos disfrutaron de talleres, concursos y exhibiciones, mientras más de 40 cometas surcaban el cielo al mismo tiempo, ofreciendo un espectáculo inolvidable.El evento, organizado por la FUNDACIÓN DEPORTIVA ELINA MORALES, fomentó la convivencia, la creatividad y el trabajo en equipo. Gracias al apoyo de la comunidad, ¡este maratón será una tradición anual!Un día lleno de magia que dejó a todos esperando con ansias la próxima edición.";
document.getElementById("descripcionCometas").textContent=descripcionmatCometas;

// tercer evento
const visita ="Visita Educativa a Aseo del Norte: Fomentando el Interés por la Sostenibilidad";
document.getElementById("tituloVisita").textContent=visita;
const descripcionVisita ="Estudiantes de la Institución Prudencia Daza participaron en una visita a Aseo del Norte en Valledupar, organizada por FUNDAEM dentro del programa Visión de mi Futuro. Durante la jornada, aprendieron sobre higiene, manejo de residuos y prácticas sostenibles a través de un recorrido por las instalaciones, charlas educativas con profesionales del sector, demostraciones prácticas de reciclaje y una sesión de preguntas y respuestas. La experiencia les permitió comprender la importancia de la responsabilidad ambiental, valorar el trabajo en este ámbito y considerar posibles carreras relacionadas con la sostenibilidad y el cuidado del medio ambiente.";
document.getElementById("descripcionVisita").textContent=descripcionVisita;

const token = localStorage.getItem("token");

async function mostrarBotonCrearSiEsAdmin() {
    if (!token) return;

    try {
        const res = await fetch("/api/usuarios/perfil", {
            headers: {
                "Authorization": `Bearer ${token}`
            }
        });

        if (!res.ok) return;
        const usuario = await res.json();

        if (usuario.rol === "ADMIN") {
            document.getElementById("botonCrearContainer").style.display = "block";
        }
    } catch (error) {
        console.error("Error al verificar el rol:", error);
    }
}

document.addEventListener("DOMContentLoaded", mostrarBotonCrearSiEsAdmin);


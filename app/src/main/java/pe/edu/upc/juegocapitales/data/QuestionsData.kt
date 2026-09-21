package pe.edu.upc.juegocapitales.data

import pe.edu.upc.juegocapitales.model.Question


object QuestionsData {

    val americaQuestions = listOf(
        Question("¿La capital de Perú es Lima?", true, "America"),
        Question("¿La capital de Brasil es Brasilia?", true, "America"),
        Question("¿La capital de Argentina es Buenos Aires?", true, "America"),
        Question("¿La capital de Colombia es Bogotá?", true, "America"),
        Question("¿La capital de Chile es Santiago?", true, "America"),
        Question("¿La capital de Ecuador es Quito?", true, "America"),
        Question("¿La capital de México es Cancún?", false, "America"),
        Question("¿La capital de Canadá es Toronto?", false, "America"),
        Question("¿La capital de Estados Unidos es Washington D.C.?", true, "America"),
        Question("¿La capital de Uruguay es Asunción?", false, "America")
    )

    val europeQuestions = listOf(
        Question("¿La capital de España es Madrid?", true, "Europa"),
        Question("¿La capital de Francia es París?", true, "Europa"),
        Question("¿La capital de Italia es Roma?", true, "Europa"),
        Question("¿La capital de Alemania es Berlín?", true, "Europa"),
        Question("¿La capital de Portugal es Lisboa?", true, "Europa"),
        Question("¿La capital de Grecia es Atenas?", true, "Europa"),
        Question("¿La capital de Austria es Viena?", true, "Europa"),
        Question("¿La capital de Suecia es Oslo?", false, "Europa"),
        Question("¿La capital de Irlanda es Londres?", false, "Europa"),
        Question("¿La capital de Bélgica es Ámsterdam?", false, "Europa")
    )

    val asiaQuestions = listOf(
        Question("¿La capital de Japón es Tokio?", true, "Asia"),
        Question("¿La capital de China es Pekín?", true, "Asia"),
        Question("¿La capital de Corea del Sur es Seúl?", true, "Asia"),
        Question("¿La capital de Tailandia es Bangkok?", true, "Asia"),
        Question("¿La capital de India es Nueva Delhi?", true, "Asia"),
        Question("¿La capital de Vietnam es Hanói?", true, "Asia"),
        Question("¿La capital de Filipinas es Manila?", true, "Asia"),
        Question("¿La capital de Indonesia es Bangkok?", false, "Asia"),
        Question("¿La capital de Nepal es Tokio?", false, "Asia"),
        Question("¿La capital de Mongolia es Pekín?", false, "Asia")
    )

    val africaQuestions = listOf(
        Question("¿La capital de Egipto es El Cairo?", true, "Africa"),
        Question("¿La capital de Kenia es Nairobi?", true, "Africa"),
        Question("¿La capital de Marruecos es Rabat?", true, "Africa"),
        Question("¿La capital de Etiopía es Adís Abeba?", true, "Africa"),
        Question("¿La capital de Ghana es Acra?", true, "Africa"),
        Question("¿La capital de Nigeria es Abuya?", true, "Africa"),
        Question("¿La capital de Senegal es Dakar?", true, "Africa"),
        Question("¿La capital de Angola es Nairobi?", false, "Africa"),
        Question("¿La capital de Argelia es Casablanca?", false, "Africa"),
        Question("¿La capital de Túnez es El Cairo?", false, "Africa")
    )

    val oceaniaQuestions = listOf(
        Question("¿La capital de Australia es Canberra?", true, "Oceania"),
        Question("¿La capital de Nueva Zelanda es Wellington?", true, "Oceania"),
        Question("¿La capital de Fiyi es Suva?", true, "Oceania"),
        Question("¿La capital de Samoa es Apia?", true, "Oceania"),
        Question("¿La capital de Tonga es Nukualofa?", true, "Oceania"),
        Question("¿La capital de Vanuatu es Port Vila?", true, "Oceania"),
        Question("¿La capital de Papúa Nueva Guinea es Port Moresby?", true, "Oceania"),
        Question("¿La capital de Australia es Sídney?", false, "Oceania"),
        Question("¿La capital de Nueva Zelanda es Auckland?", false, "Oceania"),
        Question("¿La capital de Fiyi es Canberra?", false, "Oceania")
    )

    val allQuestions =
        americaQuestions +
                europeQuestions +
                asiaQuestions +
                africaQuestions +
                oceaniaQuestions
}
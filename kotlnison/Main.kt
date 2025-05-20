import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.routing.*
import io.ktor.html.*
import kotlinx.html.*

fun main() {
    embeddedServer(Netty, port = 8080) {
        routing {
            get("/") {
                call.respondHtml {
                    body {
                        h1 { +"To-Do Uygulaması" }
                        ul {
                            li { +"Görev 1" }
                            li { +"Görev 2" }
                        }
                        a(href = "/add") { +"Yeni Görev Ekle" }
                    }
                }
            }
            get("/add") {
                call.respondHtml {
                    body {
                        form(action = "/save", method = FormMethod.post) {
                            label { +"Görev Adı: " }
                            textInput(name = "name")
                            submitInput()
                        }
                    }
                }
            }
            post("/save") {
                // Görev ekleme kısmı buraya yazılır
            }
        }
    }.start(wait = true)
}
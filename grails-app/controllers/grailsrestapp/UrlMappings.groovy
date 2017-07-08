package grailsrestapp

class UrlMappings {

    static mappings = {
        def namespace = "v1"
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: 'application', action: 'index')
        "500"(view: '/error')
        "404"(view: '/notFound')

//        group "/api/$namespace/book" {
//            "/create"(controller: "book", action: "create", method: "POST", parseRequest: true)
//            "/$id"(controller: "book", action: "create", method: "GET", parseRequest: true)
//        }
        "/api/$namespace/book/create"(controller: "book", action: "create", method: "POST", parseRequest: true)
        "/api/$namespace/book/$id"(controller: "book", action: "fetchBook", method: "GET", parseRequest: true)

    }
}

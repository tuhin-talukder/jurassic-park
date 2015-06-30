class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/$controller"{
            action = [GET:"index", POST: "create"]
        }
        "/$controller/$id"{
            action = [PUT:"update", DELETE: "delete", GET: "show"]
        }
        "/"(view:"/index")
        "500"(controller: 'application', action: 'error')
	}
}

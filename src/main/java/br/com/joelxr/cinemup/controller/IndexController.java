package br.com.joelxr.cinemup.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

/**
 *
 * @author joel
 */
@Resource
public class IndexController {
    
    Result result;

    public IndexController(Result result) {
        this.result = result;
    }
    
    @Path("/")
    public void index() {
        result.forwardTo(HomeController.class).home();
    }
    
}

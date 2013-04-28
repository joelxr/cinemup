package br.com.joelxr.cinemup.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

/**
 *
 * @author joel
 */
@Resource
public class HomeController {

    Result result;
    
    @Path("/home")
    public void home() {
        
    }
}

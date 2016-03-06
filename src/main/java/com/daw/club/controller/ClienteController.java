package com.daw.club.controller;

import com.daw.club.model.Cliente;
import com.daw.club.model.dao.ClienteDAO;
import com.daw.club.model.dao.MedioPagoDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    //@Qualifier("clienteDAOJdbc") //avoid ambiguity with differents DAO implementations
    @Qualifier("clienteDAOList")
    private ClienteDAO clienteDAO;
    @Autowired
    private MedioPagoDAO mediosPago;
    
    public ClienteController() {
    }
    
// Not necessary using Autowired
//    public void setClienteDAO(ClienteDAO clienteDAO) {
//        this.clienteDAO=clienteDAO;
//    }
    
@ModelAttribute
private void configView(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
    //Common variables for Views
    model.addAttribute("srvUrl", request.getContextPath()+request.getServletPath()+"/clientes");
    model.addAttribute("imgUrl", request.getContextPath()+"/images");
    model.addAttribute("mediosPago", mediosPago.buscaTodos().toArray());
}
    
@RequestMapping(value={"","/listado"}, method=RequestMethod.GET)
public String listado(ModelMap model) {
        List<Cliente> clientes=clienteDAO.buscaTodos();
        model.addAttribute("clientes", clientes);
        return "clientes/listado_jstl";
}

@RequestMapping(value = "/visualiza", method=RequestMethod.GET)
public String visualiza(@RequestParam(value="id",defaultValue="0")Integer id, ModelMap model ) {        
        model.addAttribute("cliente",clienteDAO.buscaId(id));
        return "clientes/visualiza";
}

//Sample Path info param
@RequestMapping(value = "/visualiza/{id}", method=RequestMethod.GET)
public String visualizaId(@PathVariable Integer id, ModelMap model ) {        
        model.addAttribute("cliente",clienteDAO.buscaId(id));
        return "clientes/visualiza";
}

@RequestMapping(value = "/borra", method=RequestMethod.GET)
public String borra(@RequestParam(value="id",defaultValue="0")Integer id, ModelMap model) {
        clienteDAO.borra(id);
        model.clear();
        return "redirect:";
}

@RequestMapping(value = "/crea", method=RequestMethod.GET)
public String creaForm(ModelMap model) {
        model.addAttribute("cliente",new Cliente());
        return "clientes/crea";
}

@RequestMapping(value = "/crea", method=RequestMethod.POST)
public String crea( @ModelAttribute("cliente") @Valid Cliente cliente, BindingResult result, ModelMap model) {
        String view="redirect:listado"; //default view

        //Programatic validation
        //if (checkDNI(cliente.getDNI())==false)  {
        //   result.rejectValue("dni", "error.cliente.dniduplicado", "El NIF ya lo tiene otro usuario");
        //   result.rejectValue("dni", "error.cliente.dniduplicado");
        //}
        if (!result.hasErrors()) {
            clienteDAO.crea(cliente);
            model.clear();
        }else {
            view="clientes/crea"; //ask for correct data
        }
        return view;
}

@RequestMapping(value = "/edita", method=RequestMethod.GET)
public String editaForm(@RequestParam(value="id",defaultValue="0")Integer id, ModelMap model ) {
    model.addAttribute("cliente", clienteDAO.buscaId(id));
    return "clientes/edita";
}

@RequestMapping(value = "/edita", method=RequestMethod.POST)
public String edita(@ModelAttribute("cliente") @Valid Cliente cliente, BindingResult result, ModelMap model) {
    String view="redirect:visualiza/"; 
    if (!result.hasErrors()) {        
        clienteDAO.guarda(cliente);
        model.clear();
        view=view+cliente.getId();
    } else {
        view="clientes/edita"; //ask for correct data
    }
    return view;
}

//@ExceptionHandler
//public String errorHandler (Exception e) {
//    
//    return "generalError.jsp";
//}
    
}

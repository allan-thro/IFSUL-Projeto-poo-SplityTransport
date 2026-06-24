package com.pwzt.ifsul.splitytransport.api.controller;

import com.pwzt.ifsul.splitytransport.api.dto.response.cte.ResponseCTeEmissao;
import com.pwzt.ifsul.splitytransport.api.service.CTeService;
import com.pwzt.ifsul.splitytransport.core.complextype.cte.TcCTE;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cte")
@RestController

@RequiredArgsConstructor
public class CTeController {

    private final CTeService cteService;

    @PostMapping("/emitir/{id}")
    public ResponseEntity<ResponseCTeEmissao> emitirCTe(@RequestBody TcCTE cte, @PathVariable("id") Long transportId){
        ResponseCTeEmissao response = (ResponseCTeEmissao) cteService.emitir(cte, transportId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}

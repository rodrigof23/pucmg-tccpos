package com.controlevendas.controlevendas.util;

import com.controlevendas.controlevendas.model.Produto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.List;

public class DeserializadorUtil {
	
    private ObjectMapper mapper;

    public DeserializadorUtil() {
        this.mapper = new ObjectMapper();
        this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * Metodo responsavel por realizar a deserializacao dos produtos recebidos na mensagem
     *
     * @param menssagem Mensagem a ser deserializada
     * @return Lista dos produto recebidos
     * @throws IOException
     * 
     * @author Rodrigo de Freitas Santos
     */
    public List<Produto> deserializarProdutos(String menssagem) throws IOException {
        ObjectNode node = this.mapper.readValue(menssagem, ObjectNode.class);
        ObjectReader reader = this.mapper.readerFor(new TypeReference<List<Produto>>() {});
        return reader.readValue(node.get("produtos"));
    }

}

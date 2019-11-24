package com.controlevendas.controlevendas.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.controlevendas.controlevendas.model.Pedido;
import com.controlevendas.controlevendas.model.PedidoMenssagemAWS;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

@Component
public final class AWSUtil {
	
	private static final Logger log = LogManager.getLogger(AWSUtil.class);
	
    private static String accessKey;
    private static String secretKey;
    
    private AWSUtil() { }

    @Value("${cloud.aws.credentials.accessKey}")
    public void initializeAccessKey(String accessKey) {
    	AWSUtil.setAccessKey(accessKey);
    }
    
    private static void setAccessKey(String accessKey) {
    	AWSUtil.accessKey = accessKey;
    }

    @Value("${cloud.aws.credentials.secretKey}")
    public void initializeSecretKey(String secretKey) {
    	AWSUtil.setSecretKey(secretKey);
    }
    
    private static void setSecretKey(String secretKey) {
    	AWSUtil.secretKey = secretKey;
    }
	
    /**
     * Metodo que faz a autenticacao da AWS
     * 
     * @return Inteface para acessar o SNS da AWS
     * 
	 * @author Rodrigo de Freitas Santos
     */
    private static AmazonSNS retornaSNSClienteAWS(){
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWSUtil.accessKey, AWSUtil.secretKey);

        return AmazonSNSClientBuilder.standard().withRegion(Regions.US_EAST_2)
        		.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
    }
    
    /**
     * Metodo que envia a notificacao da AWS
     * 
     * @param topico Nome do topico da notificacao
     * @param message Mensagem que sera enviada
     * @throws JsonProcessingException
     * 
	 * @author Rodrigo de Freitas Santos
     */
    public static void enviaNotificacaoAWS(String topico, Pedido pedido) throws JsonProcessingException {
    	String menssagem = AWSUtil.criaMensagemNotificacaoAWS(pedido);
    	AWSUtil.retornaSNSClienteAWS().publish(topico, menssagem);
		log.info("Notificação de pedido enviada com sucesso.");
	}
    
    /**
     * Metodo responsavel por montar a mensagem que sera enviada para AWS
     * 
     * @param pedido Objeto pedido
     * @return String com a menssagem que sera enviada
     * @throws JsonProcessingException
     * 
     * @author Rodrigo de Freitas Santos
     */
    private static String criaMensagemNotificacaoAWS(Pedido pedido) throws JsonProcessingException {
		PedidoMenssagemAWS pedidoMenssagem = new PedidoMenssagemAWS();
		pedidoMenssagem.setIdPedido(pedido.getIdPedido());
		pedidoMenssagem.setQuantidade(pedido.getNrQuantidade());
		pedidoMenssagem.setNome(pedido.getFkCartao().getNmTitularNome());
		pedidoMenssagem.setCpf(pedido.getFkCartao().getNrTitularCpf());
		pedidoMenssagem.setEndereco(pedido.getFkEndereco());
		pedidoMenssagem.setProduto(pedido.getFkProduto());
		
		List<PedidoMenssagemAWS> pedidos = new ArrayList<>();
		pedidos.add(pedidoMenssagem);
		
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode array = mapper.valueToTree(pedidos);
		JsonNode node = mapper.createObjectNode().set("pedidos", array);
		
		return mapper.writeValueAsString(node);
	}

}

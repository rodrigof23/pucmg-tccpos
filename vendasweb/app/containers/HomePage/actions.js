/**
 * Arquivo com as ações que podem ser disparadas na HomePage
 *
 * @author Rodrigo de Freitas Santos
 */

import {
  LOAD_PRODUTO_LIST,
  LOAD_PRODUTO_LIST_SUCCESS,
  LOAD_PRODUTO_LIST_ERROR,

  REGISTRAR_PEDIDO,
  REGISTRAR_PEDIDO_SUCCESS,
  REGISTRAR_PEDIDO_ERROR
} from './constants';

export function loadProdutoList() {
  return {
    type: LOAD_PRODUTO_LIST
  };
}
export function loadProdutoListSuccess(data) {
  return {
    type: LOAD_PRODUTO_LIST_SUCCESS,
    data
  };
}
export function loadProdutoListError(error) {
  return {
    type: LOAD_PRODUTO_LIST_ERROR,
    error
  };
}

export function registrarPedido(pedido) {
  return {
    type: REGISTRAR_PEDIDO,
    pedido
  };
}
export function registrarPedidoSuccess(data) {
  return {
    type: REGISTRAR_PEDIDO_SUCCESS,
    data
  };
}
export function registrarPedidoError(error) {
  return {
    type: REGISTRAR_PEDIDO_ERROR,
    error
  };
}

/**
 * Métodos que fazem as requisições para o backend da HomePage
 *
 * @author Rodrigo de Freitas Santos
 */

import { call, put, takeLatest } from 'redux-saga/effects';
import request from 'utils/request';
import {
  loadProdutoListSuccess,
  loadProdutoListError,
  registrarPedidoSuccess,
  registrarPedidoError
} from './actions';
import { LOAD_PRODUTO_LIST, REGISTRAR_PEDIDO } from './constants';

/**
 * Retorna a lista de produtos registrados
 *
 * @returns Lista de produtos
 *
 * @author Rodrigo de Freitas Santos
 */
export function* getProdutoList() {
  const requestURL = '/api/produto/listar';
  const requestOpts = {
    method: 'GET',
    headers: {
      'Content-type': 'application/json'
    }
  };

  try {
    const response = yield call(request, requestURL, requestOpts);
    if (response.data.error) {
      throw response.data;
    }

    yield put(loadProdutoListSuccess(response.data));
  } catch (error) {
    yield put(loadProdutoListError(error));
  }
}

export function* insertPedido(action) {
  const requestURL = '/api/pedido/cadastrar';
  const requestOpts = {
    method: 'POST',
    headers: {
      'Content-type': 'application/json'
    },
    body: JSON.stringify(action.pedido),
  };

  try {
    const response = yield call(request, requestURL, requestOpts);
    if (response.data.error) {
      throw response.data;
    }

    yield put(registrarPedidoSuccess(response.data));
  } catch (error) {
    yield put(registrarPedidoError(error));
  }
}

export default function* retrievestoHomePage() {
  yield takeLatest(LOAD_PRODUTO_LIST, getProdutoList);
  yield takeLatest(REGISTRAR_PEDIDO, insertPedido);
}

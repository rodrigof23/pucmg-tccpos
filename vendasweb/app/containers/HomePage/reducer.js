/**
 * Funções para setar os states quando uma action é disparada da HomePage
 *
 * @author Rodrigo de Freitas SantosS
 */

import { fromJS } from 'immutable';

import {
  LOAD_PRODUTO_LIST,
  LOAD_PRODUTO_LIST_SUCCESS,
  LOAD_PRODUTO_LIST_ERROR,

  REGISTRAR_PEDIDO,
  REGISTRAR_PEDIDO_SUCCESS,
  REGISTRAR_PEDIDO_ERROR
} from './constants';

import { SIGN_OUT } from '../App/constants';

const initialState = fromJS({
  produtoList: false,
  pedido: false
});

function homeReducer(state = initialState, action) {
  switch (action.type) {
    case SIGN_OUT:
      return initialState;

    case LOAD_PRODUTO_LIST:
      return state
        .set('produtoList', {
          data: false,
          loading: true,
          error: false
        });
    case LOAD_PRODUTO_LIST_SUCCESS:
      return state
        .set('produtoList', {
          data: action.data,
          loading: false,
          error: false
        });
    case LOAD_PRODUTO_LIST_ERROR:
      return state
        .set('produtoList', {
          data: false,
          loading: false,
          error: action.error
        });

    case REGISTRAR_PEDIDO:
      return state
        .set('pedido', {
          data: false,
          loading: true,
          error: false
        });
    case REGISTRAR_PEDIDO_SUCCESS:
      return state
        .set('pedido', {
          data: action.data,
          loading: false,
          error: false
        });
    case REGISTRAR_PEDIDO_ERROR:
      return state
        .set('pedido', {
          data: false,
          loading: false,
          error: action.error
        });

    default:
      return state;
  }
}

export default homeReducer;

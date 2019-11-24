/**
 * Funções para selecionar os states da HomePage
 *
 * @author Rodrigo de Freitas Santos
 */

import { createSelector } from 'reselect';

const selectHome = (state) => state.get('home');

const makeSelectProdutoList = () => createSelector(
  selectHome,
  (homeState) => homeState.get('produtoList')
);

const makeSelectPedido = () => createSelector(
  selectHome,
  (homeState) => homeState.get('pedido')
);

export {
  selectHome,
  makeSelectProdutoList,
  makeSelectPedido
};

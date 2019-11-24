/**
 * Arquivo de incialização da HomePage, com configuração e definição dos states e das funções utilizados
 *
 * @author Rodrigo de Freitas Santos
 */

import { connect } from 'react-redux';
import { compose } from 'redux';
import { createStructuredSelector } from 'reselect';
import injectReducer from 'utils/injectReducer';
import injectSaga from 'utils/injectSaga';
import { loadProdutoList, registrarPedido } from './actions';
import { makeSelectProdutoList, makeSelectPedido } from './selectors';
import reducer from './reducer';
import saga from './saga';
import HomePage from './HomePage';

const mapDispatchToProps = (dispatch) => ({
  loadProdutoList: () => { dispatch(loadProdutoList()); },
  realizarPedido: (pedido) => { dispatch(registrarPedido(pedido)); }
});

const mapStateToProps = createStructuredSelector({
  produtoList: makeSelectProdutoList(),
  pedido: makeSelectPedido()
});

const withConnect = connect(mapStateToProps, mapDispatchToProps);

const withReducer = injectReducer({ key: 'home', reducer });
const withSaga = injectSaga({ key: 'home', saga });

export default compose(withReducer, withSaga, withConnect)(HomePage);
export { mapDispatchToProps };

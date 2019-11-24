/**
 * Página que renderiza as informações exibidas na HomePage
 *
 * @author Rodrigo de Freitas Santos
 */

import React from 'react';
import PropTypes from 'prop-types';
import LoadingIndicator from 'components/LoadingIndicator';
import ProdutoItem from 'components/ProdutoItem';
import './style.scss';

export default class HomePage extends React.PureComponent {
  componentDidMount() {
    this.props.loadProdutoList();
  }

  render() {
    return (
      <article className="app_page" >
        <section>
          <div className="ct_table_title">Produtos</div>
        </section>
        <section>
          {this.props.produtoList && !this.props.produtoList.loading ?
            <div className="ct_produtos">
              {this.props.produtoList.data.map((produto) =>
                (<ProdutoItem
                  produto={produto}
                  realizarPedido={this.props.realizarPedido}
                  pedido={this.props.pedido}
                  key={produto.idProduto}
                />)
              )}
            </div>
            : <LoadingIndicator />
          }
        </section>
      </article>
    );
  }
}

HomePage.propTypes = {
  loadProdutoList: PropTypes.func,
  produtoList: PropTypes.oneOfType([
    PropTypes.bool,
    PropTypes.object
  ]),
  realizarPedido: PropTypes.func,
  pedido: PropTypes.oneOfType([
    PropTypes.bool,
    PropTypes.object
  ])
};

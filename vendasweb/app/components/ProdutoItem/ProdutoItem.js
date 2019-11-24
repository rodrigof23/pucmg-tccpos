/**
 * Componente que exibe um item produto para venda
 *
 * @author Rodrigo de Freitas Santos
 */

import React from 'react';
import PropTypes from 'prop-types';
import CompraModal from 'components/CompraModal';
import './style.scss';

class ProdutoItem extends React.PureComponent {
  render() {
    return (
      <div className="ct_produto_item" >
        <img className="produto_imagem" src={this.props.produto.urlImagem} alt={this.props.produto.nmNome} />
        <div className="produto_titulo">{this.props.produto.nmNome}</div>
        <div className="produto_descricao">{this.props.produto.dsDescricao}</div>
        <div className="ct_comprar">
          <div className="produto_valor">{`R$ ${this.props.produto.nrValor}`}</div>
          <CompraModal
            produto={this.props.produto}
            realizarPedido={this.props.realizarPedido}
            pedido={this.props.pedido}
          />
        </div>
      </div>
    );
  }
}

ProdutoItem.propTypes = {
  produto: PropTypes.oneOfType([
    PropTypes.bool,
    PropTypes.object,
  ]),
  realizarPedido: PropTypes.func,
  pedido: PropTypes.oneOfType([
    PropTypes.bool,
    PropTypes.object
  ])
};

export default ProdutoItem;

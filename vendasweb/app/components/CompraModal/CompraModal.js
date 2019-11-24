/**
 * Componente que renderiza o modal de compras
 *
 * @author Rodrigo de Freitas Santos
 */

import React from 'react';
import PropTypes from 'prop-types';
import Modal from 'react-responsive-modal';
import toastr from 'toastr';
import LoadingIndicator from 'components/LoadingIndicator';
import InputTextIconRight from 'components/InputTextIconRight';
import ButtonSuccess from 'components/ButtonSuccess';
import { ClipboardTextIcon } from 'mdi-react';
import './style.scss';

class ExportArchivesModal extends React.Component {
  constructor(props) {
    super(props);

    this.initialState = {
      openModal: false,
      nrQuantidade: undefined,
      nrCep: undefined,
      nmRua: '',
      nrNumero: undefined,
      nmBairro: '',
      dsComplemento: '',
      dsReferencia: '',
      formFinal: false,
      nrValorTotal: 0,
      nmTitularNome: '',
      nrTitularCpf: undefined,
      nrNumeroCartao: undefined,
      nrCodigoSeguranca: undefined,
      nrValidadeMes: undefined,
      nrValidadeAno: undefined
    };

    this.state = this.initialState;
  }

  componentDidUpdate() {
    if (this.realizarPedidoClicked && !this.props.pedido.loading) {
      this.realizarPedidoClicked = false;
      if (this.props.pedido.error) {
        toastr.error('Ocorreu um erro ao tentar realizar o pedido', 'Pedido não realizado', {
          timeOut: 5000,
          closeDuration: 500,
          closeButton: true,
          progressBar: true
        });
      } else if (this.props.pedido.data) {
        toastr.success('O pedido foi realizado com sucesso.', 'Pedido realizado', {
          timeOut: 5000,
          closeDuration: 500,
          closeButton: true,
          progressBar: true
        });
        this.closeModal();
      }
    }
  }

  /**
   * Método responsável por abrir o modal
   *
   * @author Rodrigo de Freitas Santos
   */
  openModal = () => {
    this.setState({ openModal: true });
  }

  /**
   * Método responsável por fechar o modal
   *
   * @author Rodrigo de Freitas Santos
   */
  closeModal = () => {
    this.setState(this.initialState);
  }

  enviarForm = () => {
    if (this.state.formFinal) {
      const fkEndereco = {
        nrCep: this.state.nrCep,
        nmRua: this.state.nmRua,
        nrNumero: this.state.nrNumero,
        nmBairro: this.state.nmBairro,
        dsComplemento: this.state.dsComplemento,
        dsReferencia: this.state.dsReferencia
      };
      const fkCartao = {
        nmTitularNome: this.state.nmTitularNome,
        nrTitularCpf: this.state.nrTitularCpf,
        nrNumeroCartao: this.state.nrNumeroCartao,
        nrCodigoSeguranca: this.state.nrCodigoSeguranca,
        nrValidadeMes: this.state.nrValidadeMes,
        nrValidadeAno: this.state.nrValidadeAno
      };
      const pedido = {
        nrQuantidade: this.state.nrQuantidade,
        nrValorTotal: this.state.nrValorTotal,
        fkProduto: this.props.produto,
        fkEndereco,
        fkCartao
      };

      this.realizarPedidoClicked = true;
      this.props.realizarPedido(pedido);
    } else {
      this.setState({ formFinal: true });
    }
  }

  cancelarForm = () => {
    if (this.state.formFinal) {
      this.setState({ formFinal: false });
    } else {
      this.closeModal();
    }
  }

  renderInputEndereco = () => (
    <div>
      <div className="ct_modal_input" >
        <InputTextIconRight
          name="input_quantidade"
          type="number"
          placeholder="Quantidade"
          icon={<ClipboardTextIcon />}
          value={this.state.nrQuantidade !== undefined ? this.state.nrQuantidade : ''}
          onChange={(evt) => this.setState({
            nrQuantidade: evt.target.value,
            nrValorTotal: evt.target.value * this.props.produto.nrValor
          })}
        />
      </div>
      <br />
      <div className="ct_modal_input" >
        <InputTextIconRight
          name="input_cep"
          type="number"
          placeholder="CEP"
          icon={<ClipboardTextIcon />}
          value={this.state.nrCep !== undefined ? this.state.nrCep : ''}
          onChange={(evt) => this.setState({ nrCep: evt.target.value })}
        />
      </div>
      <br />
      <div className="ct_modal_input" >
        <InputTextIconRight
          name="input_rua"
          type="text"
          placeholder="Rua"
          icon={<ClipboardTextIcon />}
          value={this.state.nmRua}
          onChange={(evt) => this.setState({ nmRua: evt.target.value })}
        />
      </div>
      <br />
      <div className="ct_modal_input" >
        <InputTextIconRight
          name="input_numero"
          type="number"
          placeholder="Número"
          icon={<ClipboardTextIcon />}
          value={this.state.nrNumero !== undefined ? this.state.nrNumero : ''}
          onChange={(evt) => this.setState({ nrNumero: evt.target.value })}
        />
      </div>
      <br />
      <div className="ct_modal_input" >
        <InputTextIconRight
          name="input_bairro"
          type="text"
          placeholder="Bairro"
          icon={<ClipboardTextIcon />}
          value={this.state.nmBairro}
          onChange={(evt) => this.setState({ nmBairro: evt.target.value })}
        />
      </div>
      <br />
      <div className="ct_modal_input" >
        <InputTextIconRight
          name="input_complemento"
          type="text"
          placeholder="Complemento"
          icon={<ClipboardTextIcon />}
          value={this.state.dsComplemento}
          onChange={(evt) => this.setState({ dsComplemento: evt.target.value })}
        />
      </div>
      <br />
      <div className="ct_modal_input" >
        <InputTextIconRight
          name="input_referencia"
          type="text"
          placeholder="Referência"
          icon={<ClipboardTextIcon />}
          value={this.state.dsReferencia}
          onChange={(evt) => this.setState({ dsReferencia: evt.target.value })}
        />
      </div>
    </div>
  )

  renderInputCartao = () => (
    <div>
      <div className="ct_modal_input" >
        <InputTextIconRight
          name="input_valor"
          type="number"
          placeholder="Valor total"
          icon={<ClipboardTextIcon />}
          value={this.state.nrValorTotal}
          activeReadOnly
        />
      </div>
      <br />
      <div className="ct_modal_input" >
        <InputTextIconRight
          name="input_titular_nome"
          type="text"
          placeholder="Nome do titular"
          icon={<ClipboardTextIcon />}
          value={this.state.nmTitularNome}
          onChange={(evt) => this.setState({ nmTitularNome: evt.target.value })}
        />
      </div>
      <br />
      <div className="ct_modal_input" >
        <InputTextIconRight
          name="input_titular_cpf"
          type="number"
          placeholder="CPF do titular"
          icon={<ClipboardTextIcon />}
          value={this.state.nrTitularCpf !== undefined ? this.state.nrTitularCpf : ''}
          onChange={(evt) => this.setState({ nrTitularCpf: evt.target.value })}
        />
      </div>
      <br />
      <div className="ct_modal_input" >
        <InputTextIconRight
          name="input_numero_cartao"
          type="number"
          placeholder="Número do cartão"
          icon={<ClipboardTextIcon />}
          value={this.state.nrNumeroCartao !== undefined ? this.state.nrNumeroCartao : ''}
          onChange={(evt) => this.setState({ nrNumeroCartao: evt.target.value })}
        />
      </div>
      <br />
      <div className="ct_modal_input" >
        <InputTextIconRight
          name="input_codigo_seguranca"
          type="number"
          placeholder="Código de segurança"
          icon={<ClipboardTextIcon />}
          value={this.state.nrCodigoSeguranca !== undefined ? this.state.nrCodigoSeguranca : ''}
          onChange={(evt) => this.setState({ nrCodigoSeguranca: evt.target.value })}
        />
      </div>
      <br />
      <div className="ct_modal_input" >
        <InputTextIconRight
          name="input_validade_mes"
          type="number"
          placeholder="Mês de validade"
          icon={<ClipboardTextIcon />}
          value={this.state.nrValidadeMes !== undefined ? this.state.nrValidadeMes : ''}
          onChange={(evt) => this.setState({ nrValidadeMes: evt.target.value })}
        />
      </div>
      <br />
      <div className="ct_modal_input" >
        <InputTextIconRight
          name="input_validade_ano"
          type="number"
          placeholder="Ano de validade"
          icon={<ClipboardTextIcon />}
          value={this.state.nrValidadeAno !== undefined ? this.state.nrValidadeAno : ''}
          onChange={(evt) => this.setState({ nrValidadeAno: evt.target.value })}
        />
      </div>
    </div>
  )

  render() {
    return (
      <div className="ct_compra_modal">
        <ButtonSuccess className="produto_botao" text="Comprar" onClick={() => this.openModal()} />
        <Modal
          open={this.state.openModal}
          onClose={() => this.closeModal()}
          center
          closeOnEsc
          classNames={{ modal: 'compra_modal' }}
        >
          <div className="modal_title">
            {this.state.formFinal ? 'Pagamento' : 'Entrega'}
          </div>
          <hr className="modal_divisor" />
          {this.props.pedido && this.props.pedido.loading ?
            <div className="modal_container centered">
              <LoadingIndicator />
            </div>
            :
            <div className="modal_container">
              {this.state.formFinal ? this.renderInputCartao() : this.renderInputEndereco()}
            </div>
          }
          <hr className="modal_divisor" />
          <div className="modal_buttons">
            <button className="cancel_button" onClick={() => this.cancelarForm()}>
              {this.state.formFinal ? 'Retornar' : 'Cancelar'}
            </button>
            {this.props.pedido && this.props.pedido.loading ?
              <button className="send_button disabled" onClick={() => null}>Continuar</button>
              :
              <button className="send_button" onClick={() => this.enviarForm()}>
                {this.state.formFinal ? 'Finalizar' : 'Continuar'}
              </button>
            }
          </div>
        </Modal>
      </div>
    );
  }
}

ExportArchivesModal.propTypes = {
  produto: PropTypes.oneOfType([
    PropTypes.bool,
    PropTypes.object
  ]),
  realizarPedido: PropTypes.func,
  pedido: PropTypes.oneOfType([
    PropTypes.bool,
    PropTypes.object
  ])
};

export default ExportArchivesModal;

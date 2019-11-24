/**
 * Componente que renderiza o menu de navegação do sistema
 *
 * @author Rodrigo de Freitas Santos
 */

import React from 'react';
import NavbarLinkItem from 'components/NavbarLinkItem';
import { HomeIcon } from 'mdi-react';
import './style.scss';

class Navbar extends React.Component { // eslint-disable-line react/prefer-stateless-function
  render() {
    return (
      <div className="navbar">
        <NavbarLinkItem
          page="/home"
          icon={<HomeIcon />}
          title="Produtos"
          pageName="Produtos"
        />
      </div>
    );
  }
}

export default Navbar;

import React from "react";
import { useState } from "react";
import * as Faicons from 'react-icons/fa'
import { PROFILE_IMAGE } from "../../config/config";

const Header = ({isToggle}) => {

    const [toggle, setToggle] = useState(false);

    const handleToggleClick = () => {
        console.log("Header " + toggle)
        setToggle(!toggle);
        isToggle(toggle);
    }

    return (
        <header className="app-header">
            <div className="app-left-area">
                <span>Loja de Materiais para Construção</span>
            </div>
            <div className="app-toggle">
                <i><Faicons.FaBars onClick={handleToggleClick}/></i>
            </div>
            <div className="app-profile">
                <img src={PROFILE_IMAGE.USER} alt="foto do usuário" />
                <span>Usuário</span>
                <div className="app-logout">
                    <i><Faicons.FaSignOutAlt/></i>
                </div>
            </div>
        </header>
    )
}

export default Header;
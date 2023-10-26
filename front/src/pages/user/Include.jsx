import React, { useState } from 'react'
import * as FaIcons from 'react-icons/fa';
import * as MdIcons from 'react-icons/md';
import * as AiIcons from 'react-icons/ai';
import ShowMessage from '../../components/Messages/ShowMessage'
import { DEFAULT_BUTTON_SIZE, DEFAULT_SHOW_MESSAGE_ICON_SIZE, PROFILE_IMAGE, SERVER_GET_IMAGE } from '../../config/config';

const Include = () => {
    const [photo, setPhoto] = useState(null);

    const handleInputFile = () => {

    }

    return (
        <>
            <ShowMessage iconTitle={<FaIcons.FaUserEdit size={DEFAULT_SHOW_MESSAGE_ICON_SIZE}/>} 
                title='Cadastro de usuários'
                description='Incluir novos usuários ao sistema' 
                iconReturn={<MdIcons.MdList size={DEFAULT_SHOW_MESSAGE_ICON_SIZE}/>} 
                path='Usuário' 
                url='/user/list' 
                titleUrl='Listagem de usuários'
            />
            <div className='row justify-content-center'>
                <div className='col-xs-12 col-sm-12 col-md-12 col-lg-10'>
                    <div className='app-window'>
                        <div className='row'>
                            <div className='col-xs-12 col-sm-12 col-md-4'>
                                <div className='card'>
                                    <div className='card-body'>
                                        <div className='d-flex flex-column align-items-center text-center'>
                                            <img src={photo === null ? 
                                                PROFILE_IMAGE.AVATAR : 
                                                `${SERVER_GET_IMAGE}${photo}`} alt="Foto do usuário" />
                                        </div>
                                        <div className='mt-3 col-xs-12 col-sm-12 col-md-10'>
                                            <div className='fileInput'>
                                                <input type='file' onChange='handleInputFile'/>
                                                <button id='uploadFile' className='btn btn-success btn-lg uploadFile' title='Enviar foto do usuário'>
                                                    <i>
                                                        <FaIcons.FaUpload size={DEFAULT_BUTTON_SIZE}/>
                                                    </i>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div className='col-xs-12 col-sm-12 col-md-8'>
                            <form className='mt-3'>
                                <div className='row mb-3'>
                                    <div className='col-xs-12 col-sm-12 col-md-12'>
                                        <div className='form-group'>
                                            <label  htmlFor="username" className='control-label'>Nome de usuário:</label>
                                            <input type="text" id='username' name='username' className='form-control'/>
                                        </div>
                                    </div>
                                </div>
                                <div className='row mb-3'>
                                    <div className='col-xs-12 col-sm-12 col-md-12'>
                                        <div className='form-group'>
                                            <label  htmlFor="email" className='control-label'>E-mail:</label>
                                            <input type="email" id='email' name='email' className='form-control'/>
                                        </div>
                                    </div>
                                </div>
                                <div className='row mb-3'>
                                    <div className='col-xs-12 col-sm-12 col-md-12'>
                                        <div className='form-group'>
                                            <label  htmlFor="password" className='control-label'>Senha:</label>
                                            <input type="password" id='password' name='password' className='form-control'/>
                                        </div>
                                    </div>
                                </div>
                                <div className='row mb-3'>
                                    <div className='col-xs-12 col-sm-12 col-md-12'>
                                        <div className='form-group'>
                                            <label  htmlFor="rePassword" className='control-label'>Confirme a senha:</label>
                                            <input type="password" id='rePassword' name='rePassword' className='form-control'/>
                                        </div>
                                    </div>
                                </div>
                                <div>
                                    <button type='button' className='btn btn-success'>Salvar</button>
                                    <button type='button' className='btn btn-danger'>Cancelar</button>
                                </div>
                            </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Include
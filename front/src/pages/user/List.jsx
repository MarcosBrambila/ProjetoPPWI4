import React from 'react'
import { DEFAULT_SHOW_MESSAGE_ICON_SIZE, PROFILE_IMAGE, SERVER_GET_IMAGE } from '../../config/config';
import * as FaIcons from 'react-icons/fa';
import * as BsIcons from 'react-icons/bs';
import * as AiIcons from 'react-icons/ai';
import { useState } from 'react';
import { useEffect } from 'react';
import { userList } from '../../service/userService';
import ShowMessage from '../../components/Messages/ShowMessage';
import Status from './Status';
import { Link } from 'react-router-dom';

const List = () => {

    const [users, setUsers] = useState([{}]);
    const [showModal, setShowModal] = useState(false);

    useEffect(() => {
        (async function loadUsers() {
            let response = await userList()
            .catch((error) => {
                console.error(error);
            });

            setUsers(response);
        })();
    }, []);

    const handleShowModal = () => {
        setShowModal(true);
    }

    const handleCloseModal = () => {
        setShowModal(false);
    }

    return (
        <div>
            <ShowMessage iconTitle={<FaIcons.FaListAlt size={DEFAULT_SHOW_MESSAGE_ICON_SIZE}/>} 
                title='Manutenção de usuários'
                description='Listar os usuários cadastrados no sistema' 
                iconReturn={<AiIcons.AiFillDashboard size={DEFAULT_SHOW_MESSAGE_ICON_SIZE}/>} 
                path='' 
                url='/dashboard' 
                titleUrl='Dashboard'
            />
            {
                showModal ? (<Status showModal={showModal} isCloseModal={handleCloseModal}/>) : null
            }
            <div className='row'>
                <div className='col-xs-12 col-sm-12 col-md-12'>
                    <div className='app-window'>
                        <div className='row justify-content-center'>
                            <form>
                                <div className='row mb-3'>
                                    <label htmlFor='key' className='col-form-label'>Filtro:</label>
                                    <div className='col-xs-11 col-sm-11 col-md-6'>
                                        <input type="text" id='searchKey' name='key' 
                                        className='form-control'/>
                                    </div>
                                    <div className='col-xs-12 col-sm-12 col-md-4 col-lg-4'>
                                        <button type='submit'
                                            className='btn btn-primary form-control'>Procurar</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div>
                            <table className='table table-striped table-bordered table-hover app-table'>
                                <thead>
                                    <tr className='table-primary text-white app-table-header'>
                                        <th>Foto</th>
                                        <th>ID</th>
                                        <th>Nome</th>
                                        <th>Email</th>
                                        <th>Status</th>
                                        <th>Ações</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {
                                        users &&
                                        users.map((user, index) => {
                                            return (
                                                <tr className='app-table-column-center-detail' key={index}>
                                                    <td><img src={user.photo === null || user.photo === '' ? PROFILE_IMAGE.THUMBNAIL : `${SERVER_GET_IMAGE}${user.photo}`}
                                                        alt="Foto do usuário" 
                                                        className='img-avatar'
                                                        /></td>
                                                    <td>{user.id}</td>
                                                    <td>{user.userName}</td>
                                                    <td>{user.email}</td>
                                                    <td>
                                                        <input type='checkbox' className='btn-check' name={`active_${user.id}`} id={`active_${user.id}`} autoComplete='off' checked onChange={handleShowModal} />
                                                        {user.active ? (
                                                            <label className="btn btn-outline-success" htmlFor={`active_${user.id}`}><i><BsIcons.BsPersonFillCheck/></i></label>
                                                        ) : (
                                                            <label className="btn btn-outline-danger" htmlFor={`active_${user.id}`}><i><BsIcons.BsPersonFillLock/></i></label>
                                                        )}
                                                    </td>
                                                    <td>
                                                        <a href="#" type='button' className='btn btn-secondary'><i><FaIcons.FaPencilAlt/></i></a>
                                                        <a href="#" type='button' className='btn btn-danger'><i><FaIcons.FaTrashAlt/></i></a>
                                                        <a href="#" type='button' className='btn btn-info'><i><FaIcons.FaSearchPlus/></i></a>
                                                    </td>
                                                </tr> 
                                            )
                                        })
                                    }
                                </tbody>
                            </table>
                        <Link to='/user/save' className='btn btn-success'><i><FaIcons.FaPlus/></i></Link>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default List;
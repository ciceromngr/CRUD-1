import React, { useState } from 'react';
import './Styled.css';  
import api from '../../service/api';
import { useHistory } from 'react-router-dom';

export const Login = () => {

    const [email, setEmail] = useState("");
    const [senha, setSenha] = useState("");
    const history = useHistory();


    const handleLogin = async () => {
        if(email !== "" && senha !== ""){
            try {
                const params = {
                    "email": email,
                    "senha": senha
                }
        
                const resp = await api.post("/user/login", params)
                
                if(resp.data === true){
                    setEmail("");
                    setSenha("");
                    history.push("/home");
                }
            } catch (error) {
                alert("Email ou Senha invalidos!")
            }
        }else {
            alert("Todos os Campos São obrigatorios!")
        }
    }

    return (
        <div className="container">
            <div className="cards-login">
                <div className="header"><h1>login</h1></div>
                <div className="body">
                    <form >
                            <label>Email</label>
                            <input type="email" value={email} onChange={(e)=> setEmail(e.target.value)} required/>

                            <label>Senha</label>
                            <input type="password" value={senha} onChange={(e)=>setSenha(e.target.value)} required/>

                            <input className="button" type="button" value="Logar" onClick={handleLogin}/>
                    </form>
                </div>
            </div>
        </div>
    )
}       
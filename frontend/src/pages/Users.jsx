import { useEffect, useState } from 'react'
import { api } from '../services/api'

export default function Users(){
  const [users, setUsers] = useState([])
  useEffect(()=>{ api.get('/usuarios/listar').then(r=> setUsers(r.data)).catch(()=>setUsers([])) },[])
  return (
    <div>
      <h2 className="text-2xl font-semibold mb-4">Usuários</h2>
      <div className="grid gap-4">
        {users.map(u=>(
          <div key={u.id} className="p-4 bg-white rounded shadow">
            <div className="flex justify-between">
              <div>
                <p className="font-bold">{u.nome} <span className="text-sm text-gray-500">#{u.id}</span></p>
                <p className="text-sm text-gray-600">{u.email}</p>
              </div>
            </div>
            <div className="mt-3">
              <p className="font-medium">Empréstimos:</p>
              {u.loans && u.loans.length>0 ? (
                <ul className="list-disc ml-6">
                  {u.loans.map(loan => (
                    // loan can be either LoanInfo object or simple id depending on backend DTO
                    <li key={loan.loanId ?? loan}>{loan.loanId ? `Loan #${loan.loanId} — Book ${loan.bookId}` : `Book ${loan}`} </li>
                  ))}
                </ul>
              ) : <p className="text-sm text-gray-500">Nenhum empréstimo</p>}
            </div>
          </div>
        ))}
      </div>
    </div>
  )
}

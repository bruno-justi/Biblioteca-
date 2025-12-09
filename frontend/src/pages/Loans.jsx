import { useEffect, useState } from 'react'
import { api } from '../services/api'

export default function Loans(){
  const [loans, setLoans] = useState([])
  useEffect(()=>{ api.get('/loan/listar').then(r=> setLoans(r.data)).catch(()=>setLoans([])) },[])
  async function devolver(id){
    await api.put(`/loan/devolver/${id}`)
    setLoans(loans.filter(l=> l.id!==id))
  }
  return (
    <div>
      <h2 className="text-2xl font-semibold mb-4">Empréstimos</h2>
      <div className="grid gap-4">
        {loans.map(l=>(
          <div key={l.id} className="p-4 bg-white rounded shadow">
            <p className="font-bold">Loan #{l.id}</p>
            <p className="text-sm">Book: {l.bookId}</p>
            <p className="text-sm">User: {l.userId}</p>
            <p className="text-sm">Status: {l.status}</p>
            <div className="mt-2">
              {l.status !== 'DEVOLVIDO' && <button onClick={()=>devolver(l.id)} className="px-3 py-1 bg-blue-600 text-white rounded">Devolver</button>}
            </div>
          </div>
        ))}
      </div>
    </div>
  )
}

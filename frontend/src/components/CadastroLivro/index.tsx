import React, { useState } from "react"
import type { livroRequest } from "../../types/livro"
import api from "../../service/api"

interface CadastroLivroProps {
  className?: string
  reloadLivros: () => void
}

function CadastroLivro({ reloadLivros, className = "" }: CadastroLivroProps){
  const [ form, setForm ] = useState<livroRequest>({
    titulo: ""
  })

  function handleInput(e: React.ChangeEvent<HTMLInputElement>){
    const { name, value, type } = e.target

    setForm({ ...form,
      [name]: type === "number"
        ? value === "" ? null : Number(value)
        : value
    })
  }

  async function handleSubmit(e: React.SubmitEvent<HTMLFormElement>){
    e.preventDefault()

    const data: Partial<livroRequest> = Object.fromEntries(Object.entries(form)
      .filter(([_, value]) => {
        return value != null && value != 0
      }))
    
      console.log(data, form);
    try {
      
      const response = await api.post("livros", data)
      
      reloadLivros()

    } catch (err: any) {
      console.error("Deu erro aqui: ", err)
    }
  }

  return(
    <>
      <form onSubmit={handleSubmit} className={`${className} flex flex-col gap-y-8`}>
        <div className={`flex flex-col items-center gap-y-8`}>
          <div className={`flex flex-col w-3xl max-w-full gap-y-2`}>
            <label htmlFor="tituloLivro" className={`text-lg`}>Título do livro</label>
            <input type="text" name="titulo" id="tituloLivro" required
              onChange={handleInput}
              value={form.titulo}
              className={`border rounded-lg px-3 py-1.5`}
            />
          </div>
          <div className={`flex flex-col w-3xl max-w-full gap-y-2`}>
            <label htmlFor="notaLivro" className={`text-lg`}>Nota do livro</label>
            <input type="number" name="nota" id="notaLivro" max={5} min={1}
              onChange={handleInput}
              className={`border rounded-lg px-3 py-1.5`}
            />
          </div>
        </div>
        <button type="submit" className={`bg-blue-500 text-gray-50 px-12 py-3 self-center rounded-full text-lg cursor-pointer hover:bg-blue-600 active:bg-blue-700 transition-colors`}>Enviar</button>
      </form>
    </>
  )
}

export default CadastroLivro
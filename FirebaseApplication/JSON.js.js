var ocorrencias = [
	{
		_id : '001',
		_idUser : '001', //id do usuário que criou a ocorrência
		creation_date : '9999-12-31 23:59:59',
		situation : 'pending',
		resolved_date : '',
		location : [26.342653, -23.730469],
		category : 'acidente',
		description : 'blablablablablaSocorro'
	},
	{
		_id : '002',
		_idUser : '002', //id do usuário que criou a ocorrência
		creation_date : '9999-12-31 23:59:59',
		situation : 'resolved',
		resolved_date : '2016-12-31 08:01:00',
		location : [26.342653, -23.730469],
		category : 'acidente',
		description : 'blablablablablaSocorro'
	},
	{
		_id : '002',
		_idUser : '002', //id do usuário que criou a ocorrência
		creation_date : '9999-12-31 23:59:59',
		situation : 'pending',
		resolved_date : '',
		location : [26.342653, -23.730469],
		category : 'acidente',
		description : 'blablablablablaSocorro'
	}
	
]

var Users = [
    {
      _id : '001',
      name : 'Emerson',
      email : 'emerson@gmail.com',
      password : 'asd56asd4as2'
    },
    {
      _id : '002',
      name : 'Bruno',
      email : 'bruno@gmail.com',
      password : 'asd56asd4as2'
    },
    {
      _id : '003',
      name : 'João',
      email : 'jm@gmail.com',
      password : 'asd56asd4as2'
    }
  ]
  

// FUNÇÃO QUE RETORNA OCORRÊNCIAS DO USUÁRIO PELO ID  
var idUser = '002'

function filterById(item, id){
	return (item._id === idUser)
}

ocorrencias.filter(function(item){
	return filterById(item, idUser)
})



// lista de usuários
var Users = [
    {
      _id : '001',
      name : 'Emerson',
      email : 'emerson@gmail.com',
      password : 'asd56asd4as2'
    },
    {
      _id : '002',
      name : 'Bruno',
      email : 'bruno@gmail.com',
      password : 'asd56asd4as2'
    },
    {
      _id : '003',
      name : 'João',
      email : 'jm@gmail.com',
      password : 'asd56asd4as2'
    },
    
  ]
  
Users.length
//Total de usuários na lista


Users[0]
//Retorna o primeiro usuario da lista
// {
//   _id : '001',
//   name : 'Emerson',
//   email : 'emerson@gmail.com',
//   password : 'asd56asd4as2'
// }

  
Users[0]._id
//Retorna o id do primeiro usuario da lista
// '001'


for(var i = 0, l = Users.length; i < l ; i++)
	console.log(Users[i])
//Percorre a lista de usuários
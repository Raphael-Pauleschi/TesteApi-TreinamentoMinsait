package com.minsait.emprestimo.entity;

public enum Relation {
	OURO {

		@Override
		public double calcularValorFinal(Loan loan, boolean clientHasOneLoan) {
			return clientHasOneLoan ? loan.getValorInicial() * 1.2 : loan.getValorInicial()*1.3;
		}

	},
	PRATA {

		@Override
		public double calcularValorFinal(Loan loan, boolean clientHasOneLoan) {
			return loan.getValorInicial() > 5000 ? 
					loan.getValorInicial() * 1.4 : 
					loan.getValorInicial() * 1.6;
		}

	},
	BRONZE {

		@Override
		public double calcularValorFinal(Loan loan, boolean clientHasOneLoan) {
			return loan.getValorInicial() * 1.8;
		}

	};

	abstract public double calcularValorFinal(Loan loan, boolean clientHasOneLoan);
}

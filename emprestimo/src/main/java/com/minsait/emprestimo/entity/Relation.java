package com.minsait.emprestimo.entity;

public enum Relation {
	OURO {

		@Override
		public double calculateFinalValue(Loan loan, boolean clientHasOneLoan) {
			return clientHasOneLoan ? loan.getInitialValue() * 1.2 : loan.getInitialValue()*1.3;
		}

	},
	PRATA {

		@Override
		public double calculateFinalValue(Loan loan, boolean clientHasOneLoan) {
			return loan.getInitialValue() > 5000 ? 
					loan.getInitialValue() * 1.4 : 
					loan.getInitialValue() * 1.6;
		}

	},
	BRONZE {

		@Override
		public double calculateFinalValue(Loan loan, boolean clientHasOneLoan) {
			return loan.getInitialValue() * 1.8;
		}

	};

	abstract public double calculateFinalValue(Loan loan, boolean clientHasOneLoan);
}

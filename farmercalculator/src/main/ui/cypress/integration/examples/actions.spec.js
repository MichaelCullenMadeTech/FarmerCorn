/// <reference types="cypress" />

context('Actions', () => {
  beforeEach(() => {
    cy.visit('http://localhost:8080/')
  })

  // https://on.cypress.io/interacting-with-elements
  it('.click() - click on Bags increase btn', () => {
    cy.get('#bags-increase').click()
  })
  it('.click() - click on Bags decrease btn', () => {
    cy.get('#bags-increase').click()
    cy.get('#bags-decrease').click()
  })
  it('.click() - click on Geese increase btn', () => {
    cy.get('#geese-increase').click()
  })
  it('.click() - click on Geese decrease btn', () => {
    cy.get('#bags-increase').click()
    cy.get('#geese-decrease').click()
  })

  it('.click() - click on Next btn', () => {
    cy.get('#next-btn').click()
  })

  it('Continue bags and no geese', () => {
    cy.get('#bags-increase').click()
    cy.get('#bags-increase').click()
    cy.get('#bags-increase').click()
    cy.get('#bags-increase').click()
    cy.get('#next-btn').click()
    cy.get('#trip-form').should('exist');
  })

  it('Continue geese and no bags', () => {
    cy.get('#geese-increase').click()
    cy.get('#geese-increase').click()
    cy.get('#geese-increase').click()
    cy.get('#geese-increase').click()
    cy.get('#next-btn').click()
    cy.get('#trip-form').should('exist');
  })

  it('Continue with 1 geese and 1 bags', () => {
    cy.get('#geese-increase').click()
    cy.get('#geese-increase').click()
    cy.get('#geese-increase').click()
    cy.get('#geese-increase').click()
    cy.get('#next-btn').click()
    cy.get('#trip-form').should('exist');
  })

  it('Continue with 2 geese 1 corn validatoin shows.', () => {
    cy.get('#geese-increase').click()
    cy.get('#geese-increase').click()
    cy.get('#bags-increase').click()
    cy.get('#next-btn').click()
    cy.get('#trip-form').should('exist');
  })

  it('Validated with 2 bags 1 geese validatoin shows.', () => {
    cy.get('#bags-increase').click()
    cy.get('#bags-increase').click()
    cy.get('#geese-increase').click()
    cy.get('#next-btn').click()
    cy.get('#trip-form').should('exist');
  })

  it('Validated with 3 geese 1 corn validatoin shows.', () => {
    cy.get('#geese-increase').click()
    cy.get('#geese-increase').click()
    cy.get('#geese-increase').click()
    cy.get('#bags-increase').click()
    cy.get('#next-btn').click()
    cy.get('#validation-message').should('exist');
    cy.get('#trip-form').should('not.exist');
  })

  it('.click() - click Next btn with 3 bags 1 geese validatoin shows.', () => {
    cy.get('#bags-increase').click()
    cy.get('#bags-increase').click()
    cy.get('#bags-increase').click()
    cy.get('#geese-increase').click()
    cy.get('#next-btn').click()
    cy.get('#validation-message').should('exist');
    cy.get('#trip-form').should('not.exist');
  })
})

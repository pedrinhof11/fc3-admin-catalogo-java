package com.fullcycle.admin.catalogo.domain.category;

import com.fullcycle.admin.catalogo.domain.shared.exceptions.DomainException;
import com.fullcycle.admin.catalogo.domain.shared.validation.handler.ThrowsValidationHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CategoryTest {
    @Test()
    public void givenAValidParams_whenCallNewCategory_thenInstantiateACategory() {
        var expectedName = "Filmes";
        var expectedDescription = "Os mais assistidos";

        var actualCategory = Category.newCategory(expectedName, expectedDescription);

        Assertions.assertNotNull(actualCategory);
        Assertions.assertNotNull(actualCategory.getId());
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertTrue(actualCategory.isActive());
        Assertions.assertNotNull(actualCategory.getCreatedAt());
        Assertions.assertNotNull(actualCategory.getUpdatedAt());
        Assertions.assertNull(actualCategory.getDeletedAt());
    }

    @Test()
    public void givenAnInvalidNullName_whenCallNewCategory_thenShouldReceivedError() {

        var expectedErrorCount = 1;
        var expectedErrorMessage = "Name should not be null";

        var actualCategory = Category.newCategory(null, "Os mais assistidos");
        final var actualException = Assertions.assertThrows(DomainException.class, () -> actualCategory.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }


}

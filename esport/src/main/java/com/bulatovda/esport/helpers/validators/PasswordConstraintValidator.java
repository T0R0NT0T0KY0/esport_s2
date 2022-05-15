package com.bulatovda.esport.helpers.validators;

import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.stream.Collectors;

import com.google.common.base.Joiner;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

	@Override
	public void initialize(ValidPassword arg0) {
	}


	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		PasswordValidator validator = new PasswordValidator(Arrays.asList(
				// length between 8 and 100 characters
				new LengthRule(8, 100),

				// no whitespace
				new WhitespaceRule(),

				// define some illegal sequences that will fail when >= 5 chars long
				// alphabetical is of the form 'abcde', numerical is '34567', qwery is 'asdfg'
				// the false parameter indicates that wrapped sequences are allowed; e.g. 'xyzabc'
				new IllegalSequenceRule(EnglishSequenceData.Alphabetical, 5, false),
				new IllegalSequenceRule(EnglishSequenceData.Numerical, 5, false),
				new IllegalSequenceRule(EnglishSequenceData.USQwerty, 5, false),


				// at least one symbol (special character)
				new CharacterRule(EnglishCharacterData.Special, 1),

				// at least one digit character
				new CharacterRule(EnglishCharacterData.Digit, 1),

				// at least one lower-case character
				new CharacterRule(EnglishCharacterData.LowerCase, 1),

				// at least one upper-case character
				new CharacterRule(EnglishCharacterData.UpperCase, 1),
				new WhitespaceRule()));

		RuleResult result = validator.validate(new PasswordData(password));
		if (result.isValid()) {
			return true;
		}

		String messageTemplate = String.join(",", validator.getMessages(result));
		System.out.println(messageTemplate);
		context.disableDefaultConstraintViolation();
		context.buildConstraintViolationWithTemplate(messageTemplate)
				.addConstraintViolation()
				.disableDefaultConstraintViolation();

		return false;
	}
}
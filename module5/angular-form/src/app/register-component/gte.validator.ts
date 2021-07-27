import {AbstractControl, ValidationErrors} from '@angular/forms';

export function comparePassword(c: AbstractControl): ValidationErrors | null {
  const v = c.value;
  return (v.password === v.confirmpassword) ? null : {
    passwordnotmatch: true
  };
}

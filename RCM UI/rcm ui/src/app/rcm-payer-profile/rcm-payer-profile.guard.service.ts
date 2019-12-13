import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, CanDeactivate } from '@angular/router';

import { UpdateProfileComponent } from './update-profile/update-profile.component';

@Injectable()
export  class ProductEditGuard implements CanDeactivate<UpdateProfileComponent> {

    canDeactivate(component: UpdateProfileComponent): boolean {
        if (component.profileUpdateFormGroup.dirty) {
            let profile_name = component.profileUpdateFormGroup.get('profile_name').value || 'Profile Name';
            return confirm(`Navigate away and lose all changes to ${profile_name}?`);
        }
        return true;
    }
}
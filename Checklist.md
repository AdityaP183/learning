# Better Auth & Next.js Tutorial Progress Tracker 🚀

## Setup & Initial Configuration

- [x] Remove files from `public/*`
- [x] Clear `globals.css`
- [x] Clear `page.tsx`
- [x] Install shadcn `npx shadcn@latest init`
- [x] Install components `npx shadcn@latest add button label input sonner`
- [x] Show button and test `dev` server

---

## PART 1: Authentication Foundation

### Database & Prisma Setup
- [x] Install Better Auth `npm install better-auth`
- [x] Create `.env` and set Environment Variables
- [x] Create `lib/auth.ts`
- [x] Setup `postgres` database with `neon.tech`
- [x] Install prisma `npm install prisma --save-dev`
- [x] Initialize prisma `npx prisma init`
- [x] Create **Post** Model
- [x] Push database changes `npx prisma db push`
- [x] Add `generated` to `.gitignore`
- [x] Adjust **scripts** in `package.json`

### Authentication Configuration
- [x] Create single Prisma Client in `lib/prisma.ts`
- [x] Setup prisma adapter with better-auth
- [x] Generate auth tables `npx @better-auth/cli generate --output=auth.schema.prisma`
- [x] Make tweaks to `schema.prisma`
- [x] Quick walkthrough the models:
  - [x] `User`
  - [x] `Session`
  - [x] `Account`
  - [x] `Verification`
- [x] Push database changes `npx prisma db push`
- [x] Create Mount Handler in `app/api/auth/[...all]/route.ts`
- [x] Adjust `eslint.config.mjs` to ignore `/src/generated/**/*`
- [x] Create Client instance in `lib/auth-client.ts`

### Email & Password Authentication
- [x] Enable Email & Password Authentication
- [x] Create Sign Up Page PT1
  - [x] Create Form `components/register-form.tsx`
  - [x] Log Form Values
- [x] Setup Sonner
- [x] Create Sign Up Page PT2
  - [x] Add Form Validation
  - [x] Destructure SignUp Function
  - [x] Showcase `onError`
- [x] OPTIONS - **minPasswordLength**
- [x] Create Sign Up Page PT3
  - [x] Sign Up _default automatically signs in the user_
- [x] Show Session on Profile Page
- [x] Show Data in Neon Dashboard
- [x] Sign Out User
  - [x] Destructure SignOut Function
  - [x] Show Removed Cookies
- [x] Create Sign In Page PT1
  - [x] Create Form `components/login-form.tsx`
  - [x] Log Form Values
  - [x] Destructure SignIn Function
- [x] Show Unauthorized on Profile Page
- [x] Create Sign In Page PT2
  - [x] Showcase `onError`
  - [x] Sign In User

---

## PART 2: Advanced Configuration & Server Actions

### Advanced Features
- [x] Showcase `onRequest` and `onResponse`
- [x] Showcase Full Cycle Again
- [x] Add Convenience Links for Auth Pages
- [x] OPTIONS - **autoSignIn**
  - [x] Showcase
- [x] OPTIONS - **advanced.database.generateId**
  - [x] Table IDs (change `schema.prisma` and push)
  - [x] Showcase
  - [x] Truncate Tables
- [x] Sign Up User via SERVER ACTIONS
  - [x] Create Action
  - [x] Log Form Values
  - [x] Sign Up User on Server
- [x] Sign In User via SERVER ACTIONS
  - [x] Create Action
  - [x] Log Form Values
  - [x] Sign In User on Server
  - [x] Manually Set Cookies
  - [x] Passing Headers to Sign In
- [x] PLUGINS - **nextCookies()**

---

## PART 3: Session Management & Middleware

- [x] Get Session on Client
  - [x] Create Get Started Button
  - [x] Destructure useSession
- [x] Middleware
  - [x] check for existence of a session cookie
  - [x] showcase on auth routes
- [x] Error Handling
- [x] Hooks
  - [x] Validate Email
  - [x] Transform Name

---

## PART 4: Role-Based Access Control

- [ ] Roles (Custom Method)
- [ ] Prisma
  - [ ] Add UserRole Enum
  - [ ] Push changes `npx prisma db push`
- [ ] User
  - [ ] Show field is added because of `@default`
  - [ ] Truncate Tables
  - [ ] Create new User
- [ ] Profile PT1
  - [ ] Show role is not typed in `session.user`
- [ ] OPTIONS - **user.additionalFields**
  - [ ] Showcase `input` option
- [ ] Profile PT2
  - [ ] Show role is now typed and added to `session.user`
- [ ] ISSUE: Client Session has no Context of the Role
  - [ ] Cute circle on `get-started-button.tsx`
  - [ ] InferAdditionalFields plugin on Client
- [ ] Admin Panel
  - [ ] Create Page / Link
  - [ ] Manually Change Role
  - [ ] Update Middleware
  - [ ] Guard `/admin/dashboard`
  - [ ] List Users With Prisma Query
  - [ ] Delete User With Prisma Query
- [ ] Database Hooks
- [ ] Roles (Admin Plugin)
  - [ ] generate auth tables `npx @better-auth/cli generate --output=roles.schema.prisma`
  - [ ] compare and contrast (look at Schema section)
  - [ ] Push changes `npx prisma db push`
  - [ ] Create Permissions (No Posts)
  - [ ] Add to `lib/auth.ts` and `lib/auth-client.ts`
  - [ ] List Users With Admin Plugin
  - [ ] EXERCISE: Delete User With Admin Plugin
  - [ ] Change Permissions (With Posts)
- [ ] Create Dropdown to Change Role for Admins

---

## PART 5: OAuth & Social Logins

- [ ] Google OAuth
  - [ ] Create Buttons
- [ ] GitHub OAuth
- [ ] Account Linking
- [ ] Error Handling
  - [ ] `/auth/login/error`

---

## PART 6: Email Verification & Password Reset

- [ ] Nodemailer
  - [ ] Create Template
- [ ] Verify Email
  - [ ] `emailAndPassword.requireEmailVerification`
  - [ ] `emailVerification`
  - [ ] Handle Error / Expired `/auth/verify`
  - [ ] Destructure sendVerificationEmail
  - [ ] Handle Login Page Not Verified
- [ ] Create Post Sign Up Page
  - [ ] Showcase
- [ ] Forgot Password
  - [ ] Page / Form / Success
- [ ] Reset Password
  - [ ] Page / Form / Success
  - [ ] Showcase

---

## PART 7: Advanced Features & Customization

- [ ] Show the image
- [ ] Updating User
  - [ ] change name / image
  - [ ] update hook
  - [ ] updating password
- [ ] Custom Sessions
  - [ ] type inference for plugins workaround
- [ ] PLUGINS - **Magic Link**
  - [ ] add to client instance
  - [ ] Create UI
  - [ ] adjust hooks
- [ ] Cookie Cache

---

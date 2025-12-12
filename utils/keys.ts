export function getKeyName(...args: string[]) {
    return `redis:${args.join(':')}`
}
